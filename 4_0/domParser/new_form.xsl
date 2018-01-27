<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="xml" indent="yes"/>
    <xsl:param name="group" />
    <xsl:variable name="lastPresident" select="group/groupName"/>

    <xsl:template match="students">
        <students>
            <xsl:apply-templates/>
        </students>
    </xsl:template>

    <xsl:template match="student">
        <student>
            <xsl:apply-templates select="groupName"/>
        </student>
    </xsl:template>

    <xsl:template match="firstname">
        <firstname>
            <xsl:apply-templates/>
        </firstname>
    </xsl:template>

    <xsl:template match="surname">
        <surnameH>
            <xsl:apply-templates/>
        </surnameH>
    </xsl:template>

    <xsl:template match="groupName" >
        <groupH>
            <xsl:value-of select="$lastPresident"/>
        </groupH>
    </xsl:template>


</xsl:stylesheet>