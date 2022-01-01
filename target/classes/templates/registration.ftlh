<#import "parts/common.ftlh" as co>
<#import "parts/login.ftlh" as l>

<@co.page>
Add new user
${message?ifExists}
<@l.login "/registration" />
</@co.page>