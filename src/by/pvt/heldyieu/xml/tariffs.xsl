<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<xsl:output method="html" />

	<xsl:template match="/">
		<html>
			<head>
				<title>Tariffs</title>
			</head>
			<body>
				<h2 align="center">Tariffs</h2>
				<table border="1" align="center">
					<tr>
						<th>Name</th>
						<th>Operator Name</th>
						<th>Pay Roll</th>
						<th>Inside network calls</th>
						<th>Outside network calls</th>
						<th>State calls</th>
						<th>Sms-price</th>
						<th>Free gygabytes</th>
						<th>Free minutes</th>
						<th>Favourite-number</th>
						<th>Tariffication</th>
						<th>Subscrive cost</th>
					</tr>

					<xsl:for-each select="mobileProvider/tariffs/*/tariff">
						<xsl:sort select="payroll" />
						<tr>
							<td align="center">
								<xsl:value-of select="name" />
							</td>
							<td align="center">
								<xsl:value-of select="operator-name" />
							</td>
							<td align="center">
								<xsl:value-of select="payroll" />
							</td>
							<td align="center">
								<xsl:value-of select="call-prices/prices/@cost" />
							</td>
							<td align="center">
								<xsl:value-of select="call-prices/prices/@cost" />
							</td>
							<td align="center">
								<xsl:value-of select="call-prices/prices/@cost" />
							</td>
							<td align="center">
								<xsl:value-of select="sms-price" />
							</td>
							<td align="center">
								<xsl:choose>
									<xsl:when test="free-gygabytes != ''">
										<xsl:value-of select="free-gygabytes" />
									</xsl:when>
									<xsl:otherwise>
										<xsl:text>undefined</xsl:text>
									</xsl:otherwise>
								</xsl:choose>

							</td>
							<td align="center">
							<xsl:choose>
									<xsl:when test="free-minutes != ''">
										<xsl:value-of select="free-minutes" />
									</xsl:when>
									<xsl:otherwise>
										<xsl:text>undefined</xsl:text>
									</xsl:otherwise>
								</xsl:choose>
							</td>
							<td align="center">
								<xsl:value-of select="parameters/favourite-number" />
							</td>
							<td align="center">
								<xsl:value-of select="parameters/tariffication" />
							</td>
							<td align="center">
								<xsl:value-of select="parameters/subscribe-cost" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
            
   