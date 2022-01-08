<#import "parts/common.ftlh" as co>

<@co.page>
    <#if isCurrentUser>
        <#include "parts/messageEdit.ftlh" />
    </#if>
    <#include "parts/messageList.ftlh" />

</@co.page>