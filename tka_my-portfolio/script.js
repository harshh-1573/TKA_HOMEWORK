document.addEventListener('DOMContentLoaded', () => {

  // ============================================================
  // === 1. Initialize Lucide Icons ===
  // ============================================================
  lucide.createIcons();

  // ============================================================
  // === 2. Loading Screen ===
  // ============================================================
  const loadingScreen = document.getElementById('loading-screen');
  const loadingProgress = document.getElementById('loading-progress');
  const loadingPercent = document.getElementById('loading-percent');

  let progress = 0;
  const loadingInterval = setInterval(() => {
    // Increment by a random amount between 5 and 20
    const increment = Math.floor(Math.random() * 16) + 5;
    progress = Math.min(progress + increment, 100);

    // Update the progress bar width and percentage text
    loadingProgress.style.width = progress + '%';
    loadingPercent.textContent = progress + '%';

    if (progress >= 100) {
      clearInterval(loadingInterval);

      // Wait 400ms after reaching 100%, then begin hide transition
      setTimeout(() => {
        loadingScreen.classList.add('loading-hidden');

        // After the CSS transition completes (500ms), set display:none
        setTimeout(() => {
          loadingScreen.style.display = 'none';

          // Re-initialize Lucide icons for any elements that were hidden
          lucide.createIcons();
        }, 500);
      }, 400);
    }
  }, 120);

  // ============================================================
  // === 3. Typing Animation ===
  // ============================================================
  const typingText = document.getElementById('typing-text');
  const roles = [
    'Java Full Stack Developer',
    'Aspiring Java Developer',
    'Full Stack Developer',
    'MERN Stack Developer',
    'Problem Solver'
  ];
  let roleIndex = 0;
  let charIndex = 0;
  let isDeleting = false;

  function typeEffect() {
    const currentRole = roles[roleIndex];

    if (!isDeleting) {
      // Typing forward
      charIndex++;
      typingText.textContent = currentRole.substring(0, charIndex);

      if (charIndex === currentRole.length) {
        // Finished typing — pause before deleting
        isDeleting = true;
        setTimeout(typeEffect, 2000);
        return;
      }
      setTimeout(typeEffect, 100);
    } else {
      // Deleting backward
      charIndex--;
      typingText.textContent = currentRole.substring(0, charIndex);

      if (charIndex === 0) {
        // Finished deleting — move to next role
        isDeleting = false;
        roleIndex = (roleIndex + 1) % roles.length;
        setTimeout(typeEffect, 100);
        return;
      }
      setTimeout(typeEffect, 40);
    }
  }

  // Kick off the typing animation
  typeEffect();

  // ============================================================
  // === 4. Navbar Scroll Effect ===
  // ============================================================
  const navbar = document.getElementById('navbar');
  const backToTopBtn = document.getElementById('back-to-top');

  window.addEventListener('scroll', () => {
    // Add/remove 'scrolled' class based on scroll position
    if (window.scrollY > 20) {
      navbar.classList.add('scrolled');
    } else {
      navbar.classList.remove('scrolled');
    }

    // === 9. Back to Top Button visibility ===
    if (window.scrollY > 400) {
      backToTopBtn.classList.add('visible');
    } else {
      backToTopBtn.classList.remove('visible');
    }
  }, { passive: true });

  // ============================================================
  // === 5. Mobile Menu ===
  // ============================================================
  const mobileMenuBtn = document.getElementById('mobile-menu-btn');
  const mobileMenu = document.getElementById('mobile-menu');
  const menuIconOpen = document.getElementById('menu-icon-open');
  const menuIconClose = document.getElementById('menu-icon-close');

  function closeMobileMenu() {
    mobileMenu.classList.remove('open');
    menuIconOpen.style.display = 'block';
    menuIconClose.style.display = 'none';
  }

  mobileMenuBtn.addEventListener('click', () => {
    mobileMenu.classList.toggle('open');

    if (mobileMenu.classList.contains('open')) {
      menuIconOpen.style.display = 'none';
      menuIconClose.style.display = 'block';
    } else {
      menuIconOpen.style.display = 'block';
      menuIconClose.style.display = 'none';
    }
  });

  // Close mobile menu when any mobile nav link is clicked
  const mobileNavLinks = document.querySelectorAll('.mobile-nav-link');
  mobileNavLinks.forEach(link => {
    link.addEventListener('click', closeMobileMenu);
  });

  // ============================================================
  // === 6. Active Navigation Link Highlighting ===
  // ============================================================
  const sections = document.querySelectorAll(
    'section[id]'
  );
  const navLinks = document.querySelectorAll('.nav-link');
  const allMobileNavLinks = document.querySelectorAll('.mobile-nav-link');

  function setActiveLink(id) {
    navLinks.forEach(link => {
      if (link.getAttribute('href') === '#' + id) {
        link.classList.add('active');
      } else {
        link.classList.remove('active');
      }
    });
    allMobileNavLinks.forEach(link => {
      if (link.getAttribute('href') === '#' + id) {
        link.classList.add('active');
      } else {
        link.classList.remove('active');
      }
    });
  }

  const sectionObserver = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        setActiveLink(entry.target.id);
      }
    });
  }, {
    rootMargin: '-50% 0px -50% 0px',
    threshold: 0
  });

  sections.forEach(section => {
    sectionObserver.observe(section);
  });

  // ============================================================
  // === 7. Scroll Reveal Animations ===
  // ============================================================
  const scrollRevealElements = document.querySelectorAll('.scroll-reveal');

  const revealObserver = new IntersectionObserver((entries, observer) => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        entry.target.classList.add('visible');
        // Unobserve after revealing (once behavior)
        observer.unobserve(entry.target);
      }
    });
  }, {
    threshold: 0.1,
    rootMargin: '0px 0px -100px 0px'
  });

  scrollRevealElements.forEach(el => {
    revealObserver.observe(el);
  });

  // ============================================================
  // === 8. Animated Stat Counters ===
  // ============================================================
  const statCounters = document.querySelectorAll('.stat-counter');
  const animatedCounters = new Set(); // Track already-animated counters

  function animateCounter(counterEl) {
    const target = parseFloat(counterEl.getAttribute('data-target')) || 0;
    const suffix = counterEl.getAttribute('data-suffix') || '';
    const decimals = parseInt(counterEl.getAttribute('data-decimals')) || 0;
    const totalSteps = 40;
    const duration = 1500; // 1.5 seconds
    const stepTime = duration / totalSteps;
    let currentStep = 0;

    const counterInterval = setInterval(() => {
      currentStep++;
      const progressRatio = currentStep / totalSteps;
      // Ease-out curve for smoother animation
      const easedProgress = 1 - Math.pow(1 - progressRatio, 3);
      const currentValue = target * easedProgress;

      if (decimals > 0) {
        counterEl.textContent = currentValue.toFixed(decimals) + suffix;
      } else {
        counterEl.textContent = Math.floor(currentValue) + suffix;
      }

      if (currentStep >= totalSteps) {
        clearInterval(counterInterval);
        // Ensure final value is exact
        if (decimals > 0) {
          counterEl.textContent = target.toFixed(decimals) + suffix;
        } else {
          counterEl.textContent = target + suffix;
        }
      }
    }, stepTime);
  }

  const counterObserver = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
      if (entry.isIntersecting && !animatedCounters.has(entry.target)) {
        animatedCounters.add(entry.target);
        animateCounter(entry.target);
      }
    });
  }, {
    threshold: 0.3
  });

  statCounters.forEach(counter => {
    counterObserver.observe(counter);
  });

  // ============================================================
  // === 9. Back to Top Button ===
  // ============================================================
  // Visibility is handled above in the scroll listener (section 4)
  backToTopBtn.addEventListener('click', () => {
    window.scrollTo({ top: 0, behavior: 'smooth' });
  });

  // ============================================================
  // === 10. Contact Form ===
  // ============================================================
  const contactForm = document.getElementById('contact-form');
  const formSuccess = document.getElementById('form-success');
  const formSubmitBtn = document.getElementById('form-submit-btn');

  if (contactForm) {
    contactForm.addEventListener('submit', (e) => {
      e.preventDefault();

      // Basic validation — check that name, email, and message are filled
      const name = contactForm.querySelector('[name="name"]');
      const email = contactForm.querySelector('[name="email"]');
      const message = contactForm.querySelector('[name="message"]');

      if (
        (name && !name.value.trim()) ||
        (email && !email.value.trim()) ||
        (message && !message.value.trim())
      ) {
        return; // Don't submit if fields are empty
      }

      // Save original button content and show spinner
      const originalBtnContent = formSubmitBtn.innerHTML;
      formSubmitBtn.disabled = true;
      formSubmitBtn.innerHTML = '<span class="spinner"></span> Sending...';

      // Simulate a network request with 1500ms delay
      setTimeout(() => {
        // Hide the form and show success message
        contactForm.style.display = 'none';
        formSuccess.classList.add('show');

        // Reset form and button state
        contactForm.reset();
        formSubmitBtn.disabled = false;
        formSubmitBtn.innerHTML = originalBtnContent;

        // After 5 seconds, hide success and show form again
        setTimeout(() => {
          formSuccess.classList.remove('show');
          contactForm.style.display = '';
        }, 5000);
      }, 1500);
    });
  }

  // ============================================================
  // === 11. Cursor Glow (Desktop Only) ===
  // ============================================================
  const cursorGlow = document.getElementById('cursor-glow');

  function handleCursorGlow() {
    if (!cursorGlow) return;

    if (window.innerWidth > 768) {
      cursorGlow.style.display = 'block';
    } else {
      cursorGlow.style.display = 'none';
    }
  }

  // Set initial state
  handleCursorGlow();

  // Update cursor glow position on mouse move
  if (cursorGlow) {
    document.addEventListener('mousemove', (e) => {
      if (window.innerWidth <= 768) return;

      requestAnimationFrame(() => {
        cursorGlow.style.transform =
          `translate(${e.clientX - 75}px, ${e.clientY - 75}px)`;
      });
    });

    // Re-check on resize (hide on mobile, show on desktop)
    window.addEventListener('resize', handleCursorGlow);
  }

  // ============================================================
  // === 12. Smooth Scroll for Nav Links ===
  // ============================================================
  const anchorLinks = document.querySelectorAll('a[href^="#"]');

  anchorLinks.forEach(link => {
    link.addEventListener('click', (e) => {
      const targetId = link.getAttribute('href');
      if (!targetId || targetId === '#') return;

      const targetElement = document.querySelector(targetId);
      if (targetElement) {
        e.preventDefault();
        targetElement.scrollIntoView({ behavior: 'smooth' });

        // Close mobile menu if it's open
        if (mobileMenu.classList.contains('open')) {
          closeMobileMenu();
        }
      }
    });
  });

  // ============================================================
  // === 13. Year in Footer ===
  // ============================================================
  const footerYear = document.getElementById('footer-year');
  if (footerYear) {
    footerYear.textContent = new Date().getFullYear();
  }

  // ============================================================
  // === 14. Certificate Preview Toggle ===
  // ============================================================
  const toggleCertBtn = document.getElementById('toggle-cert-btn');
  const certPreviewContainer = document.getElementById('cert-preview-container');
  const certToggleText = document.getElementById('cert-toggle-text');
  const certEyeIcon = document.getElementById('cert-eye-icon');

  if (toggleCertBtn && certPreviewContainer) {
    toggleCertBtn.addEventListener('click', () => {
      certPreviewContainer.classList.toggle('open');
      const isOpen = certPreviewContainer.classList.contains('open');
      
      if (isOpen) {
        certToggleText.textContent = 'Hide Certificate';
        if (certEyeIcon) {
          certEyeIcon.setAttribute('data-lucide', 'eye-off');
          lucide.createIcons(); // Refresh Lucide icons
        }
      } else {
        certToggleText.textContent = 'Show Certificate';
        if (certEyeIcon) {
          certEyeIcon.setAttribute('data-lucide', 'eye');
          lucide.createIcons(); // Refresh Lucide icons
        }
      }
    });
  }

});
