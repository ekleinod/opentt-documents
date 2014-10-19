<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet
	version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<!-- output html, not xml -->
	<xsl:output method="html" encoding="UTF-8" />

	<!-- start of all -->
	<xsl:template match="/">
		<xsl:apply-templates />
	</xsl:template>

	<!-- start of reveal output -->
	<xsl:template match="issuedocument">
		<html>
			<meta charset="utf-8" />

			<meta name="apple-mobile-web-app-capable" content="yes" />
			<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />

			<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

			<link rel="stylesheet" href="css/reveal.min.css" />
			<link rel="stylesheet" href="css/theme/night.css" id="theme" /> <!-- default/beige/sky/night/serif/simple/solarized -->

			<head>
				<title>Regelfragen</title>
			</head>
			<body>
				<div class="reveal">
					<div class="slides">

						<section>
							<h1>Regelfragen</h1>
							<h3>Leicht bis schwierig</h3>
							<p>
								<small>Ekkart Kleinod</small>
							</p>
						</section>

						<xsl:apply-templates select="issue" />

					</div>
				</div>

				<script src="lib/js/head.min.js"></script>
				<script src="js/reveal.min.js"></script>

				<script>

					// Full list of configuration options available here:
					// https://github.com/hakimel/reveal.js#configuration
					Reveal.initialize({
						// Display controls in the bottom right corner
						controls: true,

						// Display a presentation progress bar
						progress: true,

						// Display the page number of the current slide
						slideNumber: false,

						// Push each slide change to the browser history
						history: true,

						// Enable keyboard shortcuts for navigation
						keyboard: true,

						// Enable the slide overview mode
						overview: true,

						// Vertical centering of slides
						center: true,

						// Enables touch navigation on devices with touch input
						touch: true,

						// Loop the presentation
						loop: false,

						// Change the presentation direction to be RTL
						rtl: false,

						// Turns fragments on and off globally
						fragments: true,

						// Flags if the presentation is running in an embedded mode,
						// i.e. contained within a limited portion of the screen
						embedded: false,

						// Number of milliseconds between automatically proceeding to the
						// next slide, disabled when set to 0, this value can be overwritten
						// by using a data-autoslide attribute on your slides
						autoSlide: 0,

						// Stop auto-sliding after user input
						autoSlideStoppable: true,

						// Enable slide navigation via mouse wheel
						mouseWheel: false,

						// Hides the address bar on mobile devices
						hideAddressBar: true,

						// Opens links in an iframe preview overlay
						previewLinks: false,

						// Transition style
						transition: 'default', // default/cube/page/concave/zoom/linear/fade/none

						// Transition speed
						transitionSpeed: 'default', // default/fast/slow

						// Transition style for full page slide backgrounds
						backgroundTransition: 'default', // default/none/slide/concave/convex/zoom

						// Number of slides away from the current that are visible
						viewDistance: 3,

						// Parallax background image
						parallaxBackgroundImage: '', // e.g. "'https://s3.amazonaws.com/hakim-static/reveal-js/reveal-parallax-1.jpg'"

						// Parallax background size
						parallaxBackgroundSize: '', // CSS syntax, e.g. "2100px 900px"

						theme: Reveal.getQueryHash().theme, // available themes are in /css/theme
						transition: Reveal.getQueryHash().transition || 'default', // default/cube/page/concave/zoom/linear/fade/none

						// Optional libraries used to extend on reveal.js
						dependencies: [
							// Cross-browser shim that fully implements classList - https://github.com/eligrey/classList.js/
							// { src: 'lib/js/classList.js', condition: function() { return !document.body.classList; } },

							// Interpret Markdown in section elements
							// { src: 'plugin/markdown/marked.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
							// { src: 'plugin/markdown/markdown.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },

							// Syntax highlight for code elements
							// { src: 'plugin/highlight/highlight.js', async: true, callback: function() { hljs.initHighlightingOnLoad(); } },

							// Zoom in and out with Alt+click
							// { src: 'plugin/zoom-js/zoom.js', async: true, condition: function() { return !!document.body.classList; } },

							// Speaker notes
							{ src: 'plugin/notes/notes.js', async: true, condition: function() { return !!document.body.classList; } },

							// Remote control your reveal.js presentation using a touch device
							// { src: 'plugin/remotes/remotes.js', async: true, condition: function() { return !!document.body.classList; } },

							// MathJax
							// { src: 'plugin/math/math.js', async: true }
						]
					});

				</script>

			</body>
		</html>
	</xsl:template>

	<!-- output issue -->
	<xsl:template match="issue">
		<section>
			<section>
				<xsl:apply-templates select="issuecontent[@lang = 'de']" mode="question" />
			</section>
			<section>
				<xsl:apply-templates select="issuecontent[@lang = 'de']" mode="longanswer" />
			</section>
		</section>
	</xsl:template>

	<!-- output issuecontent (questions) -->
	<xsl:template match="issuecontent" mode="question">
		<h2><xsl:value-of select="title" /></h2>

		<p><xsl:value-of select="query" /></p>
		<xsl:apply-templates select="qna" />

	</xsl:template>

	<!-- output qna -->
	<xsl:template match="qna">
		<p><xsl:value-of select="question" /></p>

		<ol>
			<xsl:apply-templates select="answer" />
		</ol>
	</xsl:template>

	<!-- output answer -->
	<xsl:template match="answer">
		<li>
			<xsl:if test="@correct = 'true'">
				<xsl:attribute name="class">fragment highlight-green</xsl:attribute>
			</xsl:if>
			<xsl:apply-templates />
		</li>
	</xsl:template>

	<!-- output issuecontent (longanswer) -->
	<xsl:template match="issuecontent" mode="longanswer">
		<h2><xsl:value-of select="title" /></h2>

		<p><xsl:value-of select="query" /></p>

		<blockquote>
			<xsl:apply-templates select="longanswer" />
		</blockquote>
	</xsl:template>

	<!-- output longanswer -->
	<xsl:template match="longanswer">
		<xsl:apply-templates />
	</xsl:template>

	<!-- output para -->
	<xsl:template match="para">
		<p><xsl:apply-templates /></p>
	</xsl:template>

</xsl:stylesheet>

<!-- EOF -->

