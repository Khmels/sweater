<#import "parts/common.ftlh" as co>
<#import "parts/login.ftlh" as l>

<@co.page>
Login page
<@l.login "/login"/>
<a href="/registration">Add new user</a>
</@co.page>