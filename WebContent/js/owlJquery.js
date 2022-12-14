$(document).ready(function () {
  $('.owl-carousel.carousel-productos').owlCarousel({
    loop: true,
    margin: 10,
    nav: true,
    autoplay:true,
    autoplayTimeout:4000,
    responsive: {
      0: {
        items: 1,
        nav:false,
        stagePadding: 40,
      },
      321: {
        items: 1,
        nav:false,
        stagePadding: 70,
      },
      376: {
        items: 1,
        nav:false,
        stagePadding: 100,
      },
      430: {
        items: 2,
        nav:false,
        stagePadding: 40,
      },
      556: {
        items: 3,
        nav:false,
        stagePadding: 40,
      },
      780: {
        items: 4,
        nav:false,
        stagePadding: 40,
      },
      1024: {
        items: 5,
        nav:false,
        stagePadding: 40,

      },
      1400: {
        items: 6,
        nav:false,
        stagePadding: 40,

      },
      1730: {
        items: 10,
        nav:false,
        stagePadding: 40,

      }
    }
  });

  $('.owl-carousel.categorias-carousel').owlCarousel({
    loop: true,
    margin: 10,
    nav: true,
    autoplay:true,
    autoplayTimeout:5000,
    responsive: {
      0: {
        items: 3,
        nav:false,
      },
      768: {
        items: 6,
        nav:false,
      },
      1000: {
        items: 6,
        nav:false,

      },
      1400: {
        items: 8,
        nav:false,
      }
    }
  });


  $('.owl-carousel.marcas-carousel').owlCarousel({
    loop: true,
    margin: 10,
    nav: true,
    autoplay:true,
    autoplayTimeout:4000,
    responsive: {
      0: {
        items: 3,
        nav:false,
      },
      768: {
        items: 6,
        nav:false,
      },
      1000: {
        items: 6,
        nav:false,

      },
      1400: {
        items: 8,
        nav:false,
      }
    }
  });

  
});


