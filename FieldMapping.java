//Component/s (id:components)
{
    cnv_component_map = {
            'Build':'CNV CI and Release',
            'Release':'CNV CI and Release',
            'Documentation':'CNV Documentation',
            'Installation':'CNV Install, Upgrade and Operators',
            'Logging':'CNV Install, Upgrade and Operators',
            'Metrics':'CNV Install, Upgrade and Operators',
            'V2V':'CNV Migration',
            'Networking':'CNV Network',
            'Providers':'CNV Providers',
            'SSP':'CNV SSP',
            'Storage':'CNV Storage',
            'User Experience':'CNV User Interface',
            'Virtualization':'CNV Virtualization',
            'Design':'CNV Release Readiness',
            'Entitlements':'CNV Release Readiness',
            'Guest Support':'CNV Virtualization',
            'RFE':'CNV Release Readiness'
        };
    ocp_component_map = {'Console Kubevirt Plugin':'CNV User Interface'};
    
    bug_component = bug.component[0];
    
    if (bug.product == 'Container Native Virtualization (CNV)') {
        bug_component ? cnv_component_map[bug_component] : null;
    } else {
        if (bug.product == 'OpenShift Container Platform') {
            bug_component ? ocp_component_map[bug_component] : null;
        }
    };
}

//Fix Version/s (id:fixVersions)
{
    if (bug.product == 'Container Native Virtualization (CNV)') {
        'CNV v' + bug.target_release[0];
    };
    if (bug.product == 'OpenShift Container Platform') {
        bugTargetRelease =  bug.target_release[0].split('\\.');
        'OpenShift ' + bugTargetRelease[0] + '.' + bugTargetRelease[1];
    }
}

//Labels (id:labels)
{
    buglabels = new("java.util.ArrayList");
    
    for (flag : bug.flags) {
        if (flag.status == '+') {
            buglabels.add(flag.name+flag.status);
        }
    };
    
    for (mykeyword : bug.keywords) {
        buglabels.add(mykeyword);
    };
    
    buglabels.add(bug.cf_internal_whiteboard);
    
    buglabels.add('cnvbugsm'); buglabels;
}

//Priority (id:priority)
{bug.priority ? ({'urgent':'Urgent','high':'High','medium':'Medium','low':'Low'})[bug.priority] : 'unprioritized'}


//Status (id:status)
{
    bzresol2jira={
        'ERRATA':'Done',                    
        'UPSTREAM':'Done',
        'WORKSFORME':'Done',
        'NOTABUG':'Obsolete',
        'WONTFIX':'Obsolete',
        'DEFERRED':'Obsolete',
        'CURRENTRELEASE':'Obsolete',
        'RAWHIDE':'Obsolete',
        'DUPLICATE':'Obsolete',
        'NEXTRELEASE':'Obsolete',
        'CANTFIX':'Obsolete',
        'INSUFFICIENT_DATA':'Obsolete',
        'EOL':'Obsolete'
    }; 

    bzstat2jira={
        'CLOSED':'Done',
        'NEW':'To Do',
        'RELEASE_PENDING':'Done',
        'VERIFIED':'Done',
        'ASSIGNED':'In Progress',
        'ON_QA':'QE Review',
        'ON_DEV':'In Progress',
        'POST':'Code Review',
        'MODIFIED':'Code Review'
    };
    
    if (bug.status == 'CLOSED'){
        bzresol2jira[bug.resolution] ? bzresol2jira[bug.resolution] : null
    } else {
        bzstat2jira[bug.status] ? bzstat2jira[bug.status] : 'To Do'
    }
}