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
			<link rel="stylesheet" href="css/theme/default.css" id="theme" />

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

						<xsl:apply-templates select="issues" />

					</div>
				</div>

				<script src="lib/js/head.min.js"></script>
				<script src="js/reveal.min.js"></script>

				<script>

					// Full list of configuration options available here:
					// https://github.com/hakimel/reveal.js#configuration
					Reveal.initialize({
						controls: true,
						progress: true,
						history: true,
						center: true,

						theme: Reveal.getQueryHash().theme, // available themes are in /css/theme
						transition: Reveal.getQueryHash().transition || 'default', // default/cube/page/concave/zoom/linear/fade/none

						// Parallax scrolling
						// parallaxBackgroundImage: 'https://s3.amazonaws.com/hakim-static/reveal-js/reveal-parallax-1.jpg',
						// parallaxBackgroundSize: '2100px 900px',

						// Optional libraries used to extend on reveal.js
						dependencies: [
							{ src: 'lib/js/classList.js', condition: function() { return !document.body.classList; } },
							{ src: 'plugin/markdown/marked.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
							{ src: 'plugin/markdown/markdown.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
							{ src: 'plugin/highlight/highlight.js', async: true, callback: function() { hljs.initHighlightingOnLoad(); } },
							{ src: 'plugin/zoom-js/zoom.js', async: true, condition: function() { return !!document.body.classList; } },
							{ src: 'plugin/notes/notes.js', async: true, condition: function() { return !!document.body.classList; } }
						]
					});

				</script>

			</body>
		</html>
	</xsl:template>

	<!-- output issues -->
	<xsl:template match="issues">
		<xsl:apply-templates select="issue" />
	</xsl:template>

	<!-- output issue -->
	<xsl:template match="issue">
		<section>
			<xsl:apply-templates select="issuecontent[@lang = 'de']" mode="question" />
		</section>
		<section>
			<xsl:apply-templates select="issuecontent[@lang = 'de']" mode="longanswer" />
		</section>
	</xsl:template>

	<!-- output issuecontent (questions) -->
	<xsl:template match="issuecontent" mode="question">
		<h2><xsl:value-of select="title" /></h2>

		<p><xsl:value-of select="query" /></p>
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

