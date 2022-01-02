<#import "parts/common.ftlh" as co>
<#import "parts/login.ftlh" as l>

<@co.page>
    <div class="mb-1"> Add new user </div>
${message?ifExists}
<@l.login "/registration" true/>
</@co.page>