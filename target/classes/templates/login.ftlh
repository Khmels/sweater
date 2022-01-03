<#import "parts/common.ftlh" as co>
<#import "parts/login.ftlh" as l>

<@co.page>
    ${message?ifExists}
    <@l.login "/login" false/>
</@co.page>