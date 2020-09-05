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