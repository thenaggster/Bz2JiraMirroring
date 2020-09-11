//Fix Version/s (id:fixVersions)
{
    myFixVersion = "";
    if (bug.product == 'Container Native Virtualization (CNV)') {
        myFixVersion = 'CNV v' + bug.target_release[0];
    };
    if (bug.product == 'OpenShift Container Platform') {
        bugTargetRelease =  bug.target_release[0].split('\\.');
        myFixVersion = 'OpenShift ' + bugTargetRelease[0] + '.' + bugTargetRelease[1];
    }

    myFixVersion;
}