//Fix Version/s (id:fixVersions)
//current
{
    myFixVersion = "";
    if (bug.product == 'Container Native Virtualization (CNV)') {
        if (!bug.target_release[0].contains('---')){
            myFixVersion = 'CNV v' + bug.target_release[0];
        }
    };
    if (bug.product == 'OpenShift Container Platform') {
        bugTargetRelease =  bug.target_release[0].split('\\.');
        if (!bugTargetRelease.contains('---')){
            myFixVersion = 'OpenShift ' + bugTargetRelease[0] + '.' + bugTargetRelease[1];
        }
    }

    myFixVersion;
}

//previous
{   myFixVersion = "";     
    if (bug.product == 'Container Native Virtualization (CNV)') {
        myFixVersion = 'CNV v' + bug.target_release[0];
    };
    
    if (bug.product == 'OpenShift Container Platform') {
        bugTargetRelease =  bug.target_release[0].split('\\.');         
        myFixVersion = 'OpenShift ' + bugTargetRelease[0] + '.' + bugTargetRelease[1];     
    }      
    myFixVersion;
}
