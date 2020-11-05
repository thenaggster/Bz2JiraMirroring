//Labels (id:labels)

//new
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
    
    bugWhiteBoards =  bug.cf_internal_whiteboard.split(',');
    for (myWhiteBoard : bugWhiteBoards) {
        buglabels.add(myWhiteBoard);
    };
    
    buglabels.add('cnvbugsm');
    
    buglabels;
}


//old
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
    
    buglabels.add('cnvbugsm');
    
    buglabels;
}