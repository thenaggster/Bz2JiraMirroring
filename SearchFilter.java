//Search Filter
{
    cnv_components_to_match =  ['V2V',
                                'Virtualization',
                                'Documentation','Storage',
                                'Guest Support',
                                'Installation',
                                'Logging',
                                'Metrics',
                                'User Experience',
                                'Networking',
                                'SSP',
                                'Providers'
                            ];
    ocp_components_to_match =  ['Console Kubevirt Plugin'];
    components_to_match = [];
    
    cnv_targeted_releases = ['2.5.0'];
    ocp_targeted_releases = ['4.6.0'];
    targeted_releases = [];
    
    if (bug.product == 'Container Native Virtualization (CNV)'){
        components_to_match = cnv_components_to_match;
        targeted_releases = cnv_targeted_releases;
    };
    
    if (bug.product == 'OpenShift Container Platform'){
        components_to_match = ocp_components_to_match;
        targeted_releases = ocp_targeted_releases;
    };
    
    cnv2_acked = false;
    for (flag : bug.flags) {
        cnv2_acked = cnv2_acked || flag.name=='cnv-2' && flag.status=='+';
        if (cnv2_acked) {break;}
    };
    
    component_matched = false;
    for (mycomponent : bug.component) {
        component_matched = component_matched || mycomponent =~ components_to_match;
        if (component_matched)
        {break;}
    };
    
    release_matched = false;
    for (mytarget_release : bug.target_release) {
        release_matched = release_matched || mytarget_release =~ targeted_releases;
        if (release_matched) {break;}
    };
    
    (bug.product == 'Container Native Virtualization (CNV)' && cnv2_acked && component_matched && release_matched) || 
        (bug.product == 'OpenShift Container Platform' && component_matched && release_matched);
}