/**
 * build.js
 * Lightweight, zero-dependency Node.js compiler for building the modular HTML components
 * into a single output `index.html` file in the root directory.
 *
 * Usage:
 *   node build.js          - Compile once
 *   node build.js --watch  - Watch src/ and auto-recompile on changes
 */

const fs = require('fs');
const path = require('path');

const SRC_DIR = path.join(__dirname, 'src');
const OUTPUT_FILE = path.join(__dirname, 'index.html');

function compile() {
  console.log('\n[Build] Starting compilation...');
  const startTime = Date.now();

  try {
    const templatePath = path.join(SRC_DIR, 'index.html');
    if (!fs.existsSync(templatePath)) {
      throw new Error(`Master template not found at ${templatePath}`);
    }

    let html = fs.readFileSync(templatePath, 'utf8');

    // Regex to match: <!-- @@include("filename") -->
    const includeRegex = /<!--\s*@@include\("([^"]+)"\)\s*-->/g;
    let match;
    let hasIncludes = true;

    // Use a loop to resolve nested or sequential includes
    while (hasIncludes) {
      const matches = [...html.matchAll(includeRegex)];
      if (matches.length === 0) {
        hasIncludes = false;
        break;
      }

      for (const m of matches) {
        const fullTag = m[0];
        const relativeIncludePath = m[1];
        const includeFilePath = path.join(SRC_DIR, relativeIncludePath);

        if (!fs.existsSync(includeFilePath)) {
          console.warn(`[Build] Warning: Include file not found at ${includeFilePath}`);
          html = html.replace(fullTag, `<!-- [Error: Include not found: ${relativeIncludePath}] -->`);
        } else {
          const includeContent = fs.readFileSync(includeFilePath, 'utf8');
          html = html.replace(fullTag, includeContent);
        }
      }
    }

    fs.writeFileSync(OUTPUT_FILE, html, 'utf8');
    const duration = Date.now() - startTime;
    console.log(`[Build] Success! Compiled to ${OUTPUT_FILE} in ${duration}ms`);
  } catch (error) {
    console.error('[Build] Compilation failed:', error.message);
  }
}

// Check arguments
const isWatchMode = process.argv.includes('--watch');

// Initial compile
compile();

if (isWatchMode) {
  console.log('[Build] Entering watch mode. Monitoring files in "src/"...');

  let watchTimeout;
  const watchDir = SRC_DIR;

  // Watch directories recursively if supported, otherwise watch files
  // Using native fs.watch
  try {
    fs.watch(watchDir, { recursive: true }, (eventType, filename) => {
      if (filename) {
        // Debounce builds to prevent double-compiles on fast successive changes
        clearTimeout(watchTimeout);
        watchTimeout = setTimeout(() => {
          console.log(`[Build] Detected change in: ${filename}`);
          compile();
        }, 100);
      }
    });
  } catch (err) {
    console.error('[Build] Failed to start watch mode. Recursive watch might not be supported on this OS: ', err.message);
  }
}
