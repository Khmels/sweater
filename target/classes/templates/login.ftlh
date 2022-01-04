<#import "parts/common.ftlh" as co>
<#import "parts/login.ftlh" as l>

<@co.page>
    <#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>
        <div class="alert alert-danger" role="alert">
            ${SPRING_SECURITY_LAST_EXCEPTION.message}
        </div>
    </#if>
    <@l.login "/login" false/>
</@co.page>