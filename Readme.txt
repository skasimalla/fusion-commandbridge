################# For executing command ##################

function doWork(doc) {
	var JC = Java.type('com.as.cb.Util.CommandUtil');
	result = JC.commandExecutor("/tmp/runScript.sh"); logger.error("chkpt1"+result);
	return doc; 
}


##################### For getting summary of a field #####################
function doWork(doc) {
	var JC = Java.type('com.as.cb.Util.Summarizer');
    try {
        if (doc.hasField("field_to_be_summarized")) {
            body = doc.getFirstFieldValue("field_to_be_summarized");
            var result = JC.summarize(body);
            doc.addField("summary", result);
     } catch (err) {
      logger.error(err)
    }
   return doc;
}

