<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="/">
	
		<html>
			<body>
			<h2>Autók</h2>
			
				<table border="1">
						<th>Rendszam</th>
						<th>
						<xsl:for-each select = "autok/auto">
							<tr>
								<xsl:value-of select="@rsz"></xsl:value-of>
							</tr>
						</xsl:for-each>
						</th>
				</table>
			
			</body>	
		</html>
	
	</xsl:template>
</xsl:stylesheet>