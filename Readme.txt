The jar that is obtained after building this code, need to be placed somewhere and the location has to be updates in the config file and then fusion has to be restarted (This is a one time activity)
./apps/jetty/connectors-classic/webapps/connectors-extra-classpath.txt
./apps//jetty/api/webapps/api-extra-classpath.txt

in 3.x it is only
./apps/jetty/api/webapps/api-extra-classpath.txt


Helpful resource
https://doc.lucidworks.com/fusion-server/4.2/search-development/getting-data-in/datasource-configuration/custom-javascript-indexing-stages.html#creating-and-accessing-java-types

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

