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