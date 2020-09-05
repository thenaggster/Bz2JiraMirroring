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
