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