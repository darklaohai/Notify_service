/**
 * @fileOverview Allows querying of the DOM using CSS selectors
 * @name cssQuery
 *
 * @author Dean Edwards
 * @verison 2.0.2 (2005-08-19)
 *
 * @copyright &copy;2004-2005 Dean Edwards (<a href="http://dean.edwards.name/" target="_blank">http://dean.edwards.name/</a>) under <a href="http://creativecommons.org/licenses/LGPL/2.1/" target="_blank">CC LGPL 2.1 License</a>
 */
eval(function(p,a,c,k,e,d){e=function(c){return(c<a?'':e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)d[e(c)]=k[c]||e(c);k=[function(e){return d[e]}];e=function(){return'\\w+'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('7 x=6(){7 1D="2.0.2";7 C=/\\s*,\\s*/;7 x=6(s,A){33{7 m=[];7 u=1z.32.2c&&!A;7 b=(A)?(A.31==22)?A:[A]:[1g];7 1E=18(s).1l(C),i;9(i=0;i<1E.y;i++){s=1y(1E[i]);8(U&&s.Z(0,3).2b("")==" *#"){s=s.Z(2);A=24([],b,s[1])}1A A=b;7 j=0,t,f,a,c="";H(j<s.y){t=s[j++];f=s[j++];c+=t+f;a="";8(s[j]=="("){H(s[j++]!=")")a+=s[j];a=a.Z(0,-1);c+="("+a+")"}A=(u&&V[c])?V[c]:21(A,t,f,a);8(u)V[c]=A}m=m.30(A)}2a x.2d;5 m}2Z(e){x.2d=e;5[]}};x.1Z=6(){5"6 x() {\\n  [1D "+1D+"]\\n}"};7 V={};x.2c=L;x.2Y=6(s){8(s){s=1y(s).2b("");2a V[s]}1A V={}};7 29={};7 19=L;x.15=6(n,s){8(19)1i("s="+1U(s));29[n]=12 s()};x.2X=6(c){5 c?1i(c):o};7 D={};7 h={};7 q={P:/\\[([\\w-]+(\\|[\\w-]+)?)\\s*(\\W?=)?\\s*([^\\]]*)\\]/};7 T=[];D[" "]=6(r,f,t,n){7 e,i,j;9(i=0;i<f.y;i++){7 s=X(f[i],t,n);9(j=0;(e=s[j]);j++){8(M(e)&&14(e,n))r.z(e)}}};D["#"]=6(r,f,i){7 e,j;9(j=0;(e=f[j]);j++)8(e.B==i)r.z(e)};D["."]=6(r,f,c){c=12 1t("(^|\\\\s)"+c+"(\\\\s|$)");7 e,i;9(i=0;(e=f[i]);i++)8(c.l(e.1V))r.z(e)};D[":"]=6(r,f,p,a){7 t=h[p],e,i;8(t)9(i=0;(e=f[i]);i++)8(t(e,a))r.z(e)};h["2W"]=6(e){7 d=Q(e);8(d.1C)9(7 i=0;i<d.1C.y;i++){8(d.1C[i]==e)5 K}};h["2V"]=6(e){};7 M=6(e){5(e&&e.1c==1&&e.1f!="!")?e:23};7 16=6(e){H(e&&(e=e.2U)&&!M(e))28;5 e};7 G=6(e){H(e&&(e=e.2T)&&!M(e))28;5 e};7 1r=6(e){5 M(e.27)||G(e.27)};7 1P=6(e){5 M(e.26)||16(e.26)};7 1o=6(e){7 c=[];e=1r(e);H(e){c.z(e);e=G(e)}5 c};7 U=K;7 1h=6(e){7 d=Q(e);5(2S d.25=="2R")?/\\.1J$/i.l(d.2Q):2P(d.25=="2O 2N")};7 Q=6(e){5 e.2M||e.1g};7 X=6(e,t){5(t=="*"&&e.1B)?e.1B:e.X(t)};7 17=6(e,t,n){8(t=="*")5 M(e);8(!14(e,n))5 L;8(!1h(e))t=t.2L();5 e.1f==t};7 14=6(e,n){5!n||(n=="*")||(e.2K==n)};7 1e=6(e){5 e.1G};6 24(r,f,B){7 m,i,j;9(i=0;i<f.y;i++){8(m=f[i].1B.2J(B)){8(m.B==B)r.z(m);1A 8(m.y!=23){9(j=0;j<m.y;j++){8(m[j].B==B)r.z(m[j])}}}}5 r};8(![].z)22.2I.z=6(){9(7 i=0;i<1z.y;i++){o[o.y]=1z[i]}5 o.y};7 N=/\\|/;6 21(A,t,f,a){8(N.l(f)){f=f.1l(N);a=f[0];f=f[1]}7 r=[];8(D[t]){D[t](r,A,f,a)}5 r};7 S=/^[^\\s>+~]/;7 20=/[\\s#.:>+~()@]|[^\\s#.:>+~()@]+/g;6 1y(s){8(S.l(s))s=" "+s;5 s.P(20)||[]};7 W=/\\s*([\\s>+~(),]|^|$)\\s*/g;7 I=/([\\s>+~,]|[^(]\\+|^)([#.:@])/g;7 18=6(s){5 s.O(W,"$1").O(I,"$1*$2")};7 1u={1Z:6(){5"\'"},P:/^(\'[^\']*\')|("[^"]*")$/,l:6(s){5 o.P.l(s)},1S:6(s){5 o.l(s)?s:o+s+o},1Y:6(s){5 o.l(s)?s.Z(1,-1):s}};7 1s=6(t){5 1u.1Y(t)};7 E=/([\\/()[\\]?{}|*+-])/g;6 R(s){5 s.O(E,"\\\\$1")};x.15("1j-2H",6(){D[">"]=6(r,f,t,n){7 e,i,j;9(i=0;i<f.y;i++){7 s=1o(f[i]);9(j=0;(e=s[j]);j++)8(17(e,t,n))r.z(e)}};D["+"]=6(r,f,t,n){9(7 i=0;i<f.y;i++){7 e=G(f[i]);8(e&&17(e,t,n))r.z(e)}};D["@"]=6(r,f,a){7 t=T[a].l;7 e,i;9(i=0;(e=f[i]);i++)8(t(e))r.z(e)};h["2G-10"]=6(e){5!16(e)};h["1x"]=6(e,c){c=12 1t("^"+c,"i");H(e&&!e.13("1x"))e=e.1n;5 e&&c.l(e.13("1x"))};q.1X=/\\\\:/g;q.1w="@";q.J={};q.O=6(m,a,n,c,v){7 k=o.1w+m;8(!T[k]){a=o.1W(a,c||"",v||"");T[k]=a;T.z(a)}5 T[k].B};q.1Q=6(s){s=s.O(o.1X,"|");7 m;H(m=s.P(o.P)){7 r=o.O(m[0],m[1],m[2],m[3],m[4]);s=s.O(o.P,r)}5 s};q.1W=6(p,t,v){7 a={};a.B=o.1w+T.y;a.2F=p;t=o.J[t];t=t?t(o.13(p),1s(v)):L;a.l=12 2E("e","5 "+t);5 a};q.13=6(n){1d(n.2D()){F"B":5"e.B";F"2C":5"e.1V";F"9":5"e.2B";F"1T":8(U){5"1U((e.2A.P(/1T=\\\\1v?([^\\\\s\\\\1v]*)\\\\1v?/)||[])[1]||\'\')"}}5"e.13(\'"+n.O(N,":")+"\')"};q.J[""]=6(a){5 a};q.J["="]=6(a,v){5 a+"=="+1u.1S(v)};q.J["~="]=6(a,v){5"/(^| )"+R(v)+"( |$)/.l("+a+")"};q.J["|="]=6(a,v){5"/^"+R(v)+"(-|$)/.l("+a+")"};7 1R=18;18=6(s){5 1R(q.1Q(s))}});x.15("1j-2z",6(){D["~"]=6(r,f,t,n){7 e,i;9(i=0;(e=f[i]);i++){H(e=G(e)){8(17(e,t,n))r.z(e)}}};h["2y"]=6(e,t){t=12 1t(R(1s(t)));5 t.l(1e(e))};h["2x"]=6(e){5 e==Q(e).1H};h["2w"]=6(e){7 n,i;9(i=0;(n=e.1F[i]);i++){8(M(n)||n.1c==3)5 L}5 K};h["1N-10"]=6(e){5!G(e)};h["2v-10"]=6(e){e=e.1n;5 1r(e)==1P(e)};h["2u"]=6(e,s){7 n=x(s,Q(e));9(7 i=0;i<n.y;i++){8(n[i]==e)5 L}5 K};h["1O-10"]=6(e,a){5 1p(e,a,16)};h["1O-1N-10"]=6(e,a){5 1p(e,a,G)};h["2t"]=6(e){5 e.B==2s.2r.Z(1)};h["1M"]=6(e){5 e.1M};h["2q"]=6(e){5 e.1q===L};h["1q"]=6(e){5 e.1q};h["1L"]=6(e){5 e.1L};q.J["^="]=6(a,v){5"/^"+R(v)+"/.l("+a+")"};q.J["$="]=6(a,v){5"/"+R(v)+"$/.l("+a+")"};q.J["*="]=6(a,v){5"/"+R(v)+"/.l("+a+")"};6 1p(e,a,t){1d(a){F"n":5 K;F"2p":a="2n";1a;F"2o":a="2n+1"}7 1m=1o(e.1n);6 1k(i){7 i=(t==G)?1m.y-i:i-1;5 1m[i]==e};8(!Y(a))5 1k(a);a=a.1l("n");7 m=1K(a[0]);7 s=1K(a[1]);8((Y(m)||m==1)&&s==0)5 K;8(m==0&&!Y(s))5 1k(s);8(Y(s))s=0;7 c=1;H(e=t(e))c++;8(Y(m)||m==1)5(t==G)?(c<=s):(s>=c);5(c%m)==s}});x.15("1j-2m",6(){U=1i("L;/*@2l@8(@\\2k)U=K@2j@*/");8(!U){X=6(e,t,n){5 n?e.2i("*",t):e.X(t)};14=6(e,n){5!n||(n=="*")||(e.2h==n)};1h=1g.1I?6(e){5/1J/i.l(Q(e).1I)}:6(e){5 Q(e).1H.1f!="2g"};1e=6(e){5 e.2f||e.1G||1b(e)};6 1b(e){7 t="",n,i;9(i=0;(n=e.1F[i]);i++){1d(n.1c){F 11:F 1:t+=1b(n);1a;F 3:t+=n.2e;1a}}5 t}}});19=K;5 x}();',62,190,'|||||return|function|var|if|for||||||||pseudoClasses||||test|||this||AttributeSelector|||||||cssQuery|length|push|fr|id||selectors||case|nextElementSibling|while||tests|true|false|thisElement||replace|match|getDocument|regEscape||attributeSelectors|isMSIE|cache||getElementsByTagName|isNaN|slice|child||new|getAttribute|compareNamespace|addModule|previousElementSibling|compareTagName|parseSelector|loaded|break|_0|nodeType|switch|getTextContent|tagName|document|isXML|eval|css|_1|split|ch|parentNode|childElements|nthChild|disabled|firstElementChild|getText|RegExp|Quote|x22|PREFIX|lang|_2|arguments|else|all|links|version|se|childNodes|innerText|documentElement|contentType|xml|parseInt|indeterminate|checked|last|nth|lastElementChild|parse|_3|add|href|String|className|create|NS_IE|remove|toString|ST|select|Array|null|_4|mimeType|lastChild|firstChild|continue|modules|delete|join|caching|error|nodeValue|textContent|HTML|prefix|getElementsByTagNameNS|end|x5fwin32|cc_on|standard||odd|even|enabled|hash|location|target|not|only|empty|root|contains|level3|outerHTML|htmlFor|class|toLowerCase|Function|name|first|level2|prototype|item|scopeName|toUpperCase|ownerDocument|Document|XML|Boolean|URL|unknown|typeof|nextSibling|previousSibling|visited|link|valueOf|clearCache|catch|concat|constructor|callee|try'.split('|'),0,{}))

/**
 * @fileOverview A library which extends the String class with some useful functions.
 * @name String Extensions
 *
 * @author Burak Yi餴t KAYA byk@amplio-vita.net
 * @version 1.1
 *
 * @copyright &copy;2008 amplio-Vita under <a href="../license.txt" target="_blank">BSD Licence</a>
 */

/**
 * Escapes the special characters for a regular expression in the string.
 *
 * @return {String}
 */
String.prototype.escapeRegExp=function()
{
	matcher=new RegExp('\\\\|\\||\\(|\\)|\\[|\\{|\\^|\\$|\\*|\\+|\\?|\\.', 'gi');
	var result;
	var outText='';
	var lastMatch=0;
	while (result=matcher.exec(this))
	{
		outText+=this.substring(lastMatch, result.index);
		outText+='\\' + result[0];
		lastMatch=result.index+1;
	}
	delete matcher;
	outText+=this.substr(lastMatch);
	return outText;
};
/**
 * Makes the first letters of words uppercase.
 *
 * @return {String}
 * @example
 * var myText="javascript is lovely.";
 * myText.ucWords();
 * <br />Will give you "Javascript Is Lovely."
 */
String.prototype.ucWords=function() 
{
	var matcher = /\b\S+/g;
	var result;
	var outText='';
	var lastMatch=0;
	while (result=matcher.exec(this))
	{
		outText+=this.substring(lastMatch, result.index);
		outText+=result[0].charAt(0).toUpperCase() + result[0].substr(1).toLowerCase();
		lastMatch=result.index+result[0].length;
	}
	return outText;
};
/**
 * Replaces the occurences of the strings given in the fromArray with the toArray respectively.
 *
 * @return {String}
 * @param {String[]} fromArray	The string array which holds the strings-to-be-replaced
 * @param {String[]} toArray	The string array which holds the strings-to-be-replaces-with.
 * If the length of this array is smaller than the fromArray, then the last item of this array is used for undefined indexes.
 * @param {Boolean} [dontEscape] If given false the strings in the fromArray are used directly as regular expressions.
 *
 * @example
 * var myText="I love Visual Basic, CGI-Script and Ruby very much!";
 * myText.arrayReplace(["Visual Basic", "CGI-Script", "Ruby"], ["PHP", "JavaScript"]);
 * <br />Will give you "I love PHP, JavaScript and JavaScript very much!"
 */
String.prototype.arrayReplace=function(fromArray, toArray, dontEscape)
{
	var expression='';
	var replacementArray=new Object();
	var maxToIndex=toArray.length-1;
	
	for (var i=0; i<fromArray.length; i++)
	{
		expression+='|' + ((dontEscape)?fromArray[i]:fromArray[i].escapeRegExp());
		replacementArray[fromArray[i]]=toArray[Math.min(i, maxToIndex)];
	}
	
	expression=expression.substr(1);
	var matcher=new RegExp(expression, "gi");
	
	var result;
	var outText='';
	var lastMatch=0;
	
	while (result=matcher.exec(this))
	{
		outText+=this.substring(lastMatch, result.index);
		outText+=replacementArray[result[0]];
		lastMatch=result.index+result[0].length;
	}
	
	outText+=this.substr(lastMatch);
	return outText;	
};

/**
 * Counts and returns the given string's occurances.
 *
 * @return {integer}
 * @param {String} searchStr The string whose occurenses will be counted.
 * @param {Boolean} [dontEscape] If given false, the searchStr is used directly as a regular expression.
 */
String.prototype.strCount=function(searchStr, dontEscape)
{
	var occurance=0;
	if (!dontEscape)
		searchStr=searchStr.escapeRegExp();
	var matcher=new RegExp(searchStr, "gi");
	while (matcher.exec(this))
		occurance++;
	return occurance;
};

/**
 * Replaces any line breaks (\n, \r, \r\n) with &lt;br&gt; tags.
 *
 * @return {String}
 */
String.prototype.LBtoBR=function()
{
	var outText=this.replace(/(\r|\n)/g, "<br>");
	return outText;
};

/**
 * Replaces any &lt;br&gt; or &lt;br /&gt; tags with line breaks(\n). 
 *
 * @return {String}
 */
String.prototype.BRtoLB=function()
{
	outText=this.replace(/(<br>|<br \/>)/gi, "\n");
	return outText;
};

/**
 * Trims the string to the given length and puts "..." in the end of the string.
 *
 * @return {String}
 * @param {integer} length The desired maximum length of the string.
 */
String.prototype.trimToLength=function(length)
{
	return (this.length>length)?(this.substr(0, length-3) + "..."):this;
};

/**
 * Trims the whitespaces in the beginning of the text.
 *
 * @return {String}
 */
String.prototype.trimLeft=function()
{
	return this.replace(/^(\s)+/g, "");
};

/**
 * Trims the whitespaces in the end of the text.
 *
 * @return {String}
 */
String.prototype.trimRight=function()
{
	return this.replace(/(\s)+$/g, "");
};

/**
 * Trims the whitespaces around the text.
 *
 * @return {String}
 */
String.prototype.trim=function()
{
	return this.replace(/^(\s)+|(\s)+$/g, "");
};

/**
 * Strips all the HTML tags in the string.
 * Removes only the given tags if tags is given
 * 
 * @param {String|Array} [tags] The tags which will be stripped out.
 * @return {String}
 */
String.prototype.stripHTML=function(tags)
{
	if (tags && tags.join)
		tags='(' + tags.join('|') + ')';
	else if (!tags)
		tags='[^>]+';
	tags='(<[\/]?' + tags + '>)';
	var matcher=new RegExp(tags, "gi");
	return this.replace(matcher, "");
};
/**
 * Formats a string according to the given parameters.
 * Currently supports only string replacement.
 * 
 * @beta Needs testing and feedback.
 * @param {String|Number} The strings to be replaced, any number of parameters can be given.
 * @return {String} The formatted string.
 * 
 * @example
 * "%s says this function is great but %2:s claims it's not".format("BYK", "useless", "snlzkn") will give you
 * BYK says this function is great but snlzkn claims it's not
 */
String.prototype.format=function()
{
	var matcher=/%(\d*):?s/g;
	var index=0;

	var result;
	var outText='';
	var lastMatch=0;
	
	while (result=matcher.exec(this))
	{
		outText+=this.substring(lastMatch, result.index);
		outText+=(result[1] !== '')?arguments[result[1]]:arguments[index++];
		lastMatch=result.index+result[0].length;
	}
	
	outText+=this.substr(lastMatch);
	return outText;		
};

String.prototype.toObject=function(secure)
{
	if (!secure)
		return eval('(' + this + ')');
	else if (window.JSON)
		return JSON.parse(this);
};

/**
 * @fileOverview A library which extends the base Object class with some useful functions.
 * @name Object Extensions
 *
 * @author Burak Yi餴t KAYA byk@amplio-vita.net
 * @version 1.0
 *
 * @copyright &copy;2008 amplio-Vita under <a href="../license.txt" target="_blank">BSD Licence</a>
 */

/**
 * This function serializes the object to a standart URI query string.
 * 
 * @return {String} The URI query string.
  */
Object.prototype.toQueryString=function(format)
{
	if (format==undefined)
		format='%s';
	var result='';
	for (var paramName in this) 
	{
		if (this.constructor==Array && isNaN(parseInt(paramName)) || !this.hasOwnProperty(paramName))
			continue;

		if (this[paramName].constructor==Object || this[paramName].constructor==Array)
			result += '&' + this[paramName].toQueryString(format.format(paramName) + '[%s]');
		else
			result += '&' + format.format(paramName) + '=' + encodeURIComponent(this[paramName]);
	}
	return result.substr(1);
};

Object.prototype.unite=function(additive, overwrite)
{
	if (overwrite!==false)
		overwrite=true;
	for (var property in additive) 
	{
		if (!additive.hasOwnProperty(property))
			continue;
		if (this[property] && this[property].constructor == Object && this.hasOwnProperty(property)) 
			this[property].unite(additive[property], overwrite);
		else if (overwrite || !(property in this))
			this[property] = additive[property];
	}

	return this;
};

/*
 * if the JSON library at http://www.json.org/json2.js is included,
 * add a "toJSON" methdo to all objects.
 */
if (window.JSON)
{
	Object.prototype.toJSONStr=function(replacer, space)
	{
		return JSON.stringify(this, replacer, space);
	};
}

/**
 * @fileOverview A cross-browser event management library
 * @name Core Event Management Library
 *
 * @author 
 * <br />Dean Edwards with input from Tino Zijdel, Matthias Miller, Diego Perini dean@edwards.name
 * <br />Adomas Paltanavicius adomas.paltanavicius@gmail.com
 * <br />Burak Yi餴t Kaya byk@amplio-vita.net
 * @version 1.2.2
 * @copyright &copy;2005 - 2008
 */

if (!aV)
	var aV={config: {}};

/**
 * Represents the namespace, aV.Events, for creating and managing event handler queues for any element.
 *
 * @namespace
 */
aV.Events = {};

/**
 * A counter used to create unique IDs for given event handlers.
 *
 * @private
 * @type integer
 */
aV.Events.guid=1;

/**
 * Adds the given event handler to element's the on-type event's event handler queue.
 *
 * @return {Function(EventObject)} The assigned function
 * @param {Object} element The element which the event handler will be added
 * @param {String} type The name of the event without the "on" prefix
 * @param {Function(EventObject)} handler The event handler function
 *
 * @example
 * function resizeAlert(e)
 * {
 * 	alert("You have resized the window!");
 * }
 * aV.Events.add(window, "resize", resizeAlert);
 */
aV.Events.add=function(element, type, handler)
{
	// assign each event handler a unique ID
	if (!handler.$$guid) handler.$$guid = aV.Events.guid++;
	// create a hash table of event types for the element
	if (!element.events) element.events = {};
	// create a hash table of event handlers for each element/event pair
	var handlers = element.events[type];
	if (!handlers) {
		handlers = element.events[type] = {};
		// store the existing event handler (if there is one)
		if (element["on" + type]) {
			handlers[0] = element["on" + type];
		}
	}
	// store the event handler in the hash table
	handlers[handler.$$guid] = handler;
	// assign a global event handler to do all the work
	element["on" + type] = aV.Events._handle;
	return handler;
};

/**
 * Removes the given event handler from element's the on-type event's event handler queue.
 *
 * @param {Object} element The element which the event handler will be removed
 * @param {String} type The name of the event without the "on" prefix
 * @param {Function(EventObject)} handler The event handler function
 *
 * @example
 * aV.Events.remove(window, "resize", resizeAlert);
 */
aV.Events.remove=function(element, type, handler)
{
	// delete the event handler from the hash table
	if (element.events && element.events[type]) {
		delete element.events[type][handler.$$guid];
	}
};

/**
 * Clears all the event handlers attached to the given element.
 * 
 * @param {Object} element
 */
aV.Events.clear=function(element)
{
	if (!element.events)
		return;
	for (var event in element.events)
	{
		if (!element.events.hasOwnProperty(event))
			continue;

		for (var guid in element.events[event]) 
			if (element.events[event].hasOwnProperty(guid))
				delete element.events[event][guid];
		delete element.events[event];
		element["on" + event]=null;
	}
	element.events=undefined;
};

/**
 * The generic event handler which manages the event queue
 *
 * @private
 * @param {EventObject}
 * @return {Boolean}
 */
aV.Events._handle=function(event)
{
	var returnValue = true;
	// grab the event object (IE uses a global event object)
	event = event || aV.Events.fix(((this.ownerDocument || this.document || this).parentWindow || window).event);
	if (!event._type)
		event._type=event.type;
	// get a reference to the hash table of event handlers
	var handlers = this.events[event._type];
	// execute each event handler
	for (var i in handlers)
	{
		if (!handlers.hasOwnProperty(i))
			continue;
		this.$$handleEvent = handlers[i];
		if (this.$$handleEvent(event) === false)
			returnValue = false;
	}
	//delete this.$$handleEvent;
	return returnValue;
};

/**
 * Adds W3C standard event methods and properties to an IE non-standard event object
 *
 * @param {EventObject} event The IE non-standard event object
 * @return {EventObject} The event object which supports W3C standard event methods
 */
aV.Events.fix=function(event)
{
	event.target=event.srcElement;
	event.preventDefault = function() {this.returnValue=false;};
	event.stopPropagation = function() {this.cancelBubble=true;};
	return event;
};

/**
 * Handles the mouse wheel event and iterprets it for a browser independent usage.
 * <br />Adds support for the new event <b>onwheel</b> for all applicable elements.
 *
 * @private
 * @return {Boolean}
 */
aV.Events._handleMouseWheelEvent=function(event)
{
	if (!event) /* For IE. */
		event = aV.Events.fix(window.event);

	event._type="wheel";
	event.delta=0;
	if (event.wheelDelta) /* IE/Opera. */
	{
		event.delta = event.wheelDelta/120;
		/** In Opera 9, delta differs in sign as compared to IE.
		 */
		if (window.opera)
			event.delta = -event.delta;
	}
	else if (event.detail) /** Mozilla case. */
	{
		/** In Mozilla, sign of delta is different than in IE.
		 * Also, delta is multiple of 3.
		 */
		event.delta = -event.detail/3;
	}
	/** If delta is nonzero, handle it.
	 * Basically, delta is now positive if wheel was scrolled up,
	 * and negative, if wheel was scrolled down.
	 */
	if (event.target && event.delta)
	{
		event._target=event.target;
		while (event._target!=document && !event._target.onwheel)
			event._target=event._target.parentNode;
		if (event._target.onwheel)
			event._target.onwheel(event);
	}
};

/* Initialization code for onwheel */
if (window.addEventListener)
	// DOMMouseScroll is for mozilla
	window.addEventListener('DOMMouseScroll', aV.Events._handleMouseWheelEvent, false);
// IE/Opera
window.onmousewheel = document.onmousewheel = aV.Events._handleMouseWheelEvent;

/**
 * @fileOverview A function-based AJAX library which also comes with useful XML functions such as <a href="#aV.AJAX.XML.getValue">aV.AJAX.XML.getValue</a> and <a href="#aV.AJAX.XML.setValue">aV.AJAX.XML.setValue</a>.
 * @name Core AJAX and XML Library
 *
 * @author Burak Yi餴t KAYA	byk@amplio-vita.net
 * @version 1.6
 * @copyright &copy;2008 amplio-Vita under <a href="../license.txt" target="_blank">BSD Licence</a>
 */

if (!aV)
	var aV={config: {}};
	
/**
 * Represents the namespace, aV.AJAX, for the core AJAX functions and global parameters of those functions.
 *
 * @namespace
 * @param {String} [config.noAjax="You need an AJAX supported browser to use this page."] The error message which user will see if his/her browser does not support AJAX.
 * If you want to disable this warning, just set this to false.
 * @param {String} [config.loadImgPath="images/loading_img.gif"] The "loading" gif's path, which might be used in various places. 
 * @param {String} [config.loadingText] The "loading" message which will be placed into a dynamically filled container while the content is being loaded.
 * If you want to disable this text, just set this to false.
 * @param {String} [config.pageLeaveWarning="There are one or more requests in progress. If you exit, there might be data loss."] The warning message which will be displayed to user if (s)he tries to leave the page while an AJAX request is loading.
 * If you want to disable this warning, just set this to false.
 */
aV.AJAX = {};

if (!aV.config.AJAX)
	aV.config.AJAX={};
/**
 * Holds the configuration parameters.
 */
aV.config.AJAX.unite(
	{
		noAjax: "You need an AJAX supported browser to use this page.",
		loadImgPath: "/JSLib/images/loading.gif",
		loadingText: "<br><center><img src=\"/JSLib/images/loading.gif\">Loading, please wait...</center>",
		pageLeaveWarning: "There are one or more requests in progress. If you exit, there might be data loss.",
		blankPageURL: "/JSLib/blank.html"
	}
, false);

/**
 * Tries to get an XMLHttpRequest object, returns false if the browser does not support AJAX.
 * 
 * @deprecated You should not need to use this function directly, use {@link aV.AJAX.makeRequest} to make AJAX calls.
 * @return {XMLHttpRequestObject | false} A new XMLHttpRequest object or false
 */
aV.AJAX.createRequestObject=function()
{
	var requestObject = false;
	if(window.XMLHttpRequest && !(window.ActiveXObject))
	{
		try
		{
			requestObject = new XMLHttpRequest();
		}
		catch(error)
		{
			requestObject = false;
		}
	}
	else if(window.ActiveXObject)
	{
		try
		{
			requestObject = new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch(error)
		{
			try
			{
				requestObject = new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch(error)
			{
				requestObject = false;
			}
		}
	}
	return requestObject;
};

/**
 * Destroys the given XMLHttpRequest object safely.
 * Aborts the request if it is active.
 *
 * @param {XMLHttpRequestObject} requestObject The requestObject which will be destroyed
 */
aV.AJAX.destroyRequestObject=function(requestObject)
{
	if (requestObject)
	{
		if ((requestObject.readyState!=4) && (requestObject.readyState!=0))
			requestObject.abort();
		requestObject=undefined;
	}
};

aV.AJAX.createCrossDomainRequestObject=function()
{
	var requestObject={};
	var callBackUrl=window.location.protocol + '//' + window.location.host + '/' + aV.config.AJAX.blankPageURL;
	requestObject.$$guid=aV.AJAX._crossDomainRequestLastGuid++;
	requestObject._container=document.createElement("span");
	requestObject._container.innerHTML='<iframe style="display:none" id="aVAJAXFrame' + requestObject.$$guid + '" name="aVAJAXFrame' + requestObject.$$guid + '" onload="this.loaded()"></iframe>';
	requestObject._container.iframe=requestObject._container.firstChild;
	requestObject._container.iframe.loaded=function()
	{
		if (!requestObject.status)
		{
			requestObject.status=200;
			this.contentWindow.location = callBackUrl;
			return;
		}
		requestObject.responseText=this.contentWindow.name;
		try
		{
			if (window.DOMParser)
				requestObject.responseXML=(new DOMParser()).parseFromString(requestObject.responseText, "application/xml");
			else if (window.ActiveXObject)
			{
				requestObject.responseXML=new ActiveXObject("Microsoft.XMLDOM");
				requestObject.responseXML.async=false;
				requestObject.responseXML.loadXML(requestObject.responseText);
			}
			else
				throw new Error("Cannot find an XML parser!");
		}
		catch(error)
		{
			requestObject.responseXML=null;
		}
		requestObject.readyState=4;
		requestObject._doReadyStateChange();

		setTimeout(function(){document.body.removeChild(requestObject._container); delete requestObject._container;}, 0);
	};
	
	requestObject.readyState=1;
	requestObject.status=0;
	
	requestObject._doReadyStateChange=function()
	{
		if (requestObject.onreadystatechange)
			requestObject.onreadystatechange({type: "readystatechange", target: requestObject});
	};

	requestObject.open=function(method, address)
	{
		if (this._container.form)
			this._container.removeChild(this._container.form);

		this._container.form=this._container.appendChild(document.createElement("form"));
		this._container.form.style.display='none';
		this._container.form.target=requestObject._container.iframe.name;
		this._container.form.method=method;
		this._container.form.action=address;
		requestObject.readyState=2;
		requestObject._doReadyStateChange();
	};
	
	requestObject.setRequestHeader=function(header, value)
	{
		header=header.toLowerCase();
		header=aV.AJAX.headerTranslations[header];
		if (!(this._container.form && (header in this._container.form)))
			return false;
		this._container.form[header]=value;
		return true;
	};
	
	requestObject.send=function(parameters)
	{
		parameters=(parameters)?parameters.split('&'):[];
		var matcher=/^([^&=]+)=([^&]+)$/;
		var pair, parameterObj;
		for (var i = 0; i < parameters.length; i++) 
		{
			pair = parameters[i].match(matcher);
			if (!(pair && pair[1]))
				continue;
			parameterObj = document.createElement("input");
			parameterObj.type = "hidden";
			parameterObj.name = pair[1];
			parameterObj.value = decodeURIComponent(pair[2]);
			this._container.form.appendChild(parameterObj);
		}
		requestObject.readyState=3;
		requestObject._doReadyStateChange();
		this._container.form.submit();
	};
	
	document.body.appendChild(requestObject._container);	
	
	return requestObject;
};

/**
 * This function is assigned to the page's onbeforeunload event for pageLeaveWarning feature.
 * See {@link aV.AJAX}.config.pageLeaveWarning
 *
 * @deprecated Should not be called directly, it is for the page's onbeforeunload event.
 * @return {String | null} pageLeaveWarning config variable or null
 */
aV.AJAX.checkActiveRequests=function()
{
	if (aV.config.AJAX.pageLeaveWarning && aV.AJAX.activeRequestCount>0)
		return aV.config.AJAX.pageLeaveWarning;
};

/**
 * Creates a new XMLHttpRequest object which connects to the address, which includes the URI encoded and merged GET parameters.
 * Assignes changeFunction to the newly created XMLHttpRequest object's onreadystatechange event.
 * Frees the XMLHttpRequest object automatically after completing the call.
 *
 * @deprecated Generally used internally from other high-level functions. Not very suitable for end-developers.
 * @return {XMLHttpRequestObject}
 * @param {String} address The address of the page which will be connected. Should include the URI encoded GET parameters.
 * @param {Function(XMLHttpRequestObject)} [changeFunction] The function which will be assigned to the newly created XMLHttpRequest object's onreadystatechange event.
 */
aV.AJAX.makeGetRequest=function(address, changeFunction, crossDomain)
{
	var requestObject = (crossDomain)?this.createCrossDomainRequestObject():this.createRequestObject(); //try to create an XMLHttpRequest object
	if (requestObject) //if the XMLHttpRequest object is valid
	{
		requestObject.open("GET", address, true); //set the address and HTTP method to GET
		requestObject.onreadystatechange = function()
		{
			try
			{
				if (changeFunction) //if there is an assigned changeFunction, assign it to the onreadystatechange event specially, that it recieves the XMLHttpRequest object as its parameter		
					changeFunction(requestObject);
			}
			catch(error)
			{
				if (window.onerror)
					window.onerror(error.message, error.fileName, error.lineNumber);
			}
			finally
			{
				if (requestObject.readyState==4)
				{
					aV.AJAX.activeRequestCount--;
					requestObject=undefined;
				}
			}
		};
		requestObject.send((crossDomain)?'&windowname=true':null); //start the request
		aV.AJAX.activeRequestCount++;
	}
	else if(aV.config.AJAX.noAjax) //if cannot create a valid XMLHttpRequest object, inform user.
		//alert(aV.config.AJAX.noAjax);
	return requestObject; //return the created XMLHttpRequest object for any further use
};

/**
 * Creates a new XMLHttpRequest object which posts the given URI query string to the given address.
 * Assignes changeFunction to the newly created XMLHttpRequest object's onreadystatechange event.
 * Frees the XMLHttpRequest object automatically after completing the call.
 *
 * @deprecated Generally used internally from other high-level functions. Not very suitable for end-developers.
 * @return {XMLHttpRequestObject}
 * @param {String} address The address of the page which will be connected. Should  NOT include any parameters.
 * @param {String} parameters The URI encoded and merged POST parameters for the HTTP request.
 * @param {Function(XMLHttpRequestObject)} [changeFunction] The function which will be assigned to the newly created XMLHttpRequest object's onreadystatechange event.
 */
aV.AJAX.makePostRequest=function(address, parameters, changeFunction, crossDomain)
{
	var requestObject = (crossDomain)?this.createCrossDomainRequestObject():this.createRequestObject(); //try to create a XMLHttpRequest object
	if (requestObject) //if XMLHttpRequest object is valid
	{
		requestObject.open("POST", address, true); //set the address and HTTP method to GET
		requestObject.onreadystatechange = function()
		{
			try
			{
				if (changeFunction) //if there is an assigned changeFunction, assign it to the onreadystatechange event specially, that it recieves the XMLHttpRequest object as its parameter		
					changeFunction(requestObject);
			}
			catch(error)
			{
				if (window.onerror)
					window.onerror(error.message, error.fileName, error.lineNumber);
			}
			finally
			{
				if (requestObject.readyState==4)
				{
					aV.AJAX.activeRequestCount--;
					requestObject=undefined;
				}
			}
		};
		if (!parameters)
			parameters='';
		requestObject.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    requestObject.setRequestHeader("Content-length", parameters.length);
    requestObject.setRequestHeader("Connection", "close");
		//set some headers for POST method
		if (crossDomain)
			parameters+='&windowname=true';
		requestObject.send(parameters); //send the request with parameters attached
		aV.AJAX.activeRequestCount++;
	}
	else if(aV.config.AJAX.noAjax) //if cannot create a valid XMLHttpRequest object, inform user.
		//alert(aV.config.AJAX.noAjax);
	return requestObject; //return the created XMLHttpRequest object for any further use
};

aV.AJAX.isCrossDomain=function(url)
{
	var matchResult=url.match(/^\w+:\/\/([^\/@ ]+)/i);
	var domain=(matchResult)?matchResult[1]:null;
	return (domain && (domain!=document.domain));
};

/**
 * Takes "GET" or "POST" as method parameter and then according to this, creates a SELF-MANAGED
 * XMLHttpRequest object using internal makeGetRequest or makePostRequest according to the method parameter.
 * Developers are strongly recommended to use THIS function instead of the above POST and GET specific functions.
 *
 * @return {XMLHttpRequestObject} The newly created XMLHttpRequest object for this specific AJAX call.
 * @param {String} method Should be either POST or GET according to the type of the HTTP request.
 * @param {String} address The address of the page which will be connected. Should  NOT include any parameters.
 * @param {String | Object} parameters The parameters which are either URI encoded and merged or given in the JSON format
 * @param {Function(XMLHttpRequestObject)} [completedFunction] The function which will be called when the HTTP call is completed. (readyState==4)
 * @param {Function(XMLHttpRequestObject)} [loadingFunction] The function which will be called EVERYTIME when an onreadystatechange event is occured with a readyState different than 4. Might be called several times before the call is completed.
 */
aV.AJAX.makeRequest=function(method, address, parameters, completedFunction, loadingFunction)
{
	var crossDomain=aV.AJAX.isCrossDomain(address);
	var triggerFunction=function (requestObject) //define the custom changeFunction as triggerFunction
	{
		if (requestObject.readyState == 4 && completedFunction) //if the request is finished and there is a  completedFunction assigned
			completedFunction(requestObject); //call the completedFunction sending the requestObject as its parameter
		else if (loadingFunction) //if request is in progress and there is an assigned loadingFunction
			loadingFunction(requestObject); //call the loadingFunction passing the requestObject as its parameter
	}; //finished defining the custom changeFunction
	//checking parameters
	if (!parameters)
		parameters='';
	if (parameters.constructor==Object)
		parameters=parameters.toQueryString();
	
	if (method.toUpperCase()=="GET") //if requested method is GET, then call the aV.AJAX.makeGetRequest function
		return this.makeGetRequest(address + ((parameters)?'?' + parameters:''), triggerFunction, crossDomain);
	else if (method.toUpperCase()=="POST") //else if requested method is POST, then call the aV.AJAX.makePostRequest function
		return this.makePostRequest(address, parameters, triggerFunction, crossDomain);
	else //if requested method is invalid, return false
		return false;
};

aV.AJAX.isResponseOK=function(requestObject, responseType)
{
	if (!responseType)
		responseType='Text';
	return (requestObject.status==200 && requestObject["response" + responseType]);
};

/**
 * Loads content to the given container element using an asynchronous HTTP GET call.
 * If the config.loadingText is defined, target container element's innerHTML is filled with its valye while the content is loading.
 *
 * @result {XMLHttpRequestObject}
 * @param {String} address The URL of the content which will be loaded dynamically into the given container.
 * @param {String|Object} element The container element itself or its id, which the dynamic content will be loaded into.
 * @param {Function(Object, String)} [completedFunction] The function which will be called when the loading of the content is finished. It is called with the target container element and the URL as parameters.
 * @param {Function(Object, String)} [loadingFunction] The function which will be called EVERYTIME when an onreadystatechange event is occured with a readyState different than 4 while loading the dynamic content. It is called with the target container element and the URL as parameters.
 */
aV.AJAX.loadContent=function(address, element, completedFunction, loadingFunction)
{
	var crossDomain=aV.AJAX.isCrossDomain(address);
	if (typeof(element)=='string') //if id of the object is given instead of the object itself
		element=document.getElementById(element); //assign the element the object corresponding to the given id
	var triggerFunction = function(requestObject) //define the custom changeFunction
	{
		if (requestObject.readyState == 4) //if the request is finished
		{
			element.innerHTML=requestObject.responseText; //fill the element's innerHTML with the returning data
			if (completedFunction) //if a callback function assigned to *callbackFunc*
				completedFunction(element, address); //call it with the element object and the given URL as its parameters
		}
		else
		{
			if (loadingFunction) //if a custom loadingFunction is assigned
				loadingFunction(element, address); //call it with the element object and the given URL as its parameters
			else if (aV.config.AJAX.loadingText)
				element.innerHTML=aV.config.AJAX.loadingText; //set the given element's innerHTML the loading text to inform the user
		}
	};
	return this.makeGetRequest(address, triggerFunction, crossDomain); //make the GET request and return the used XMLHttpRequest object
};

/**
 * Loads an external style-sheet or Javascript file on-demand.
 * Removes the old node if a resourceId is given.
 * 
 * @return {HTMLElementObject} The newly added script or link DOM node.
 * @param {String} address The address of the resource-to-be-loaded.
 * @param {String} [type="js"] The type of the resource.
 * Should be either js or css.
 * @param {String} [resourceId]	The id which will be assigned to newly created DOM node.
 * If not given, no id is assigned to the created node.
 * @param {Boolean} [forceRefresh] Addes a "?time" value at the end of the file URL to force the browser reload the file and not to use cache.
 */
aV.AJAX.loadResource=function(address, type, resourceId, forceRefresh)
{
	if (!type)
		type="js";
	if (forceRefresh)
		address+="?" + Date.parse(new Date());
	var attr, newNode;
	var head=document.getElementsByTagName("head")[0];
	if (type=="js")
	{
		newNode=document.createElement("script");
		newNode.type="text/javascript";
		attr="src";
	}
	else if (type=="css")
	{
		newNode=document.createElement("link");
		newNode.type="text/css";
		newNode.rel="stylesheet";
		attr="href";
	}
	if (resourceId)
	{
		old=document.getElementById(resourceId);
		if (old) old.parentNode.removeChild(old);
		delete old;
		newNode.id=resourceId;
	}
	newNode[attr]=address;
	return head.appendChild(newNode);
};

/**
 * @ignore
 * @param {Object} address
 * @param {Object} parameters
 * @param {Object} element
 * @param {Object} incremental
 * @param {Object} completedFunction
 * @param {Object} loadingFunction
 */
aV.AJAX.loadSelectOptions=function(address, parameters, element, incremental, completedFunction, loadingFunction)
{
	
};

/**
 * Sends the form data using AJAX when the form's onSubmit event is triggered.
 * @return {Boolean} Returns always false to prevent "real" submission.
 * @param {Object} event
 */
aV.AJAX.sendForm=function(event)
{
	var form=event.target;
/*
	if (checkRequiredFormElements)
		if (!checkRequiredFormElements(form))
		return false;
*/	
	var params={};
	for (var i = 0; i < form.elements.length; i++) 
	{
		if (form.elements[i].type=='submit' || form.elements[i].value=='' || ((form.elements[i].type=='checkbox' || form.elements[i].type=='radio') && form.elements[i].checked==false))
			continue;
		params[form.elements[i].name] = form.elements[i].value;
		form.elements[i].oldDisabled=form.elements[i].disabled;
		form.elements[i].disabled=true;
	}
	
	var completedFunction=function(requestObject)
	{
		for (var i = 0; i < form.elements.length; i++) 
			form.elements[i].disabled=form.elements[i].oldDisabled;
		if (form.callback)
			form.callback(requestObject);
	};
	
	aV.AJAX.makeRequest(form.method, form.action, params, completedFunction);
	return false;
};

/**
 * The current active requests number.
 * Changing this value is highly discouraged.
 *
 * @type integer
 */
aV.AJAX.activeRequestCount=0;

aV.AJAX._crossDomainRequestLastGuid=1;

aV.AJAX.headerTranslations=
{
	'content-type': 'enctype',
	'accept-charset': 'acceptCharset',
	'accept-language': 'lang'
};

/**
 * Introduces some useful functions for XML parsing, which are returned by the XMLHttpRequest objects's responseXML property.
 * @namespace
 */
aV.AJAX.XML = {};
/**
 * Tries to extract the node value whose name is given with nodeName and is contained by mainItem node. Returns the defaultVal if any error occurs.
 *
 * @return {String} The value of the node whose name is given with nodeName and which is contained by mainItem node.
 * @param {Object} mainItem The main node item which holds the sub nodes and their values.
 * @param {String} nodeName Name of the sub node whose value will be extracted from the mainItem.
 * @param {String} [defaultVal] The default value which will be returned if the sub node whose name is given in nodeName is not found.
 */
aV.AJAX.XML.getValue=function(mainItem, nodeName, defaultVal)
{
	defaultVal=(defaultVal) ? defaultVal : "";
	var val;
	try
	{
		val=mainItem.getElementsByTagName(nodeName)[0].firstChild.nodeValue;
		val=(val!=undefined) ? val : defaultVal;
	}
	catch(error)
	{
		val=defaultVal;
	}
	finally
	{
		return val;
	}
};

/**
 * Tries to set the node value whose name is given with nodeName and is contained by mainItem node. Returns false if any error occurs.
 *
 * @return {String} The value set by the function is returned. If an error occures, the function returns false.
 * @param {Object} mainItem The main node item which holds the sub nodes and their values.
 * @param {String} nodeName Name of the sub node whose value will be set.
 * @param {String} val The new value of the sub node whose name is given in nodeName.
 */
aV.AJAX.XML.setValue=function(mainItem, nodeName, val)
{
	try
	{
		mainItem.getElementsByTagName(nodeName)[0].firstChild.nodeValue=val;
		return val;
	}
	catch(error)
	{
		return false;
	}
};

/**
 * Converts an element/node collection, which acts as an array usually, to an actual array and returns it, which allows developers to use array-spesific functions.
 *
 * @return {HTMLElementObject[]} The array version of the given collection.
 * @param {HTMLCollectionObject} collection The collection which will be converted to array.
 */
aV.AJAX.XML.toArray=function(collection)
{
	var result = new Array();
	for (i = 0; i < collection.length; i++)
		result.push(collection[i]);
	return result;
};

aV.AJAX.XML.toObject=function(source, includeRoot)
{
	var result={};
	if (source.nodeType==9)
		source=source.firstChild;
	if (!includeRoot)
		source=source.firstChild;
	
	while (source) 
	{
		if (source.childNodes.length) 
		{
			if (source.tagName in result) 
			{
				if (result[source.tagName].constructor != Array)
					result[source.tagName] = [result[source.tagName]];
				result[source.tagName].push(aV.AJAX.XML.toObject(source));
			}
			else
				result[source.tagName] = aV.AJAX.XML.toObject(source);
		}
		else 
			result = source.nodeValue;
		source=source.nextSibling;
	}

	return result;
};

window.onbeforeunload=aV.AJAX.checkActiveRequests;

/**
 * @fileOverview A parser library which assignes elements some properties from a CSS-like external file, from a special style tag or from an inline HTML attribute.
 * @name aV.aParser
 *
 * @author Burak Yi餴t KAYA byk@amplio-vita.net
 * @version	1.2.2
 * 
 * @copyright &copy;2008 amplio-Vita under <a href="../license.txt" target="_blank">BSD Licence</a>
 */

if (!aV)
	throw new Error("aV namespace cannot be found.", "aV.main.aParser.js@" + window.location.href);

if (!aV.AJAX)
	throw new Error("aV AJAX functions library is not loaded.", "aV.main.aParser.js@" + window.location.href);

/**
 * Represents the name space for aParser's functions and methods.
 * 
 * @namespace
 * @requires {@link String} (aV.ext.string.js)
 * @requires {@link Object} (aV.ext.object.js)
 * @requires {@link aV.AJAX} (aV.main.ajax.js)
 * @requires <a href="http://dean.edwards.name/my/cssQuery/" target="_blank">cssQuery</a> (dE.cssQuery.js)
 */
aV.aParser = {};

/**
 * Evaluates and assigns the attributes given in attributeStr as string to the given element.
 * Works incrementally, which means will override existing properties but leaves the ones which
 * are not mentioned in attributeStr as they are.
 * 
 * @deprecated Used internally, might be used if necessary.
 * @return {HTMLElement} Returns the given element if succeeds, false if fails.
 * @param {HTMLElementObject} element The element whose attributes will be set.
 * @param {String} propertyName The name of the property which the parsed attributes will be assigned to.
 * @param {String} attributeStr The string which containts the attributes.
 */
aV.aParser.setElementAttributes=function(element, propertyName, attributeStr)
{
	attributeStr="{" + attributeStr + "}";
	try 
	{
		var attributes=eval('(' + attributeStr + ')');
	} 
	catch(error) 
	{
		return false;
	}
	
	if (element[propertyName])
			element[propertyName].unite(attributes);
	else
		element[propertyName]=attributes;
	
	return element;
};

/**
 * Collects the elements which satisfies the CSS query given in queryString and
 * assigns them the attributes given in attributeStr as text. If attributeStr
 * is *, then it uses the elements' inline attribute whose name is given in
 * propertyName to gather the element spesific attributeStr.
 * 
 * @deprecated Used internally, in most cases you shouldn't be in a need for calling this function.
 * @param {String} queryStr The CSS query string for determination of the proper elements.
 * @param {String} propertyName The name of the property which the parsed attributes will be assigned to.
 * @param {String} attributeStr The string which containts the attributes.
 * @param {Function(HTMLElement)} [beforeSet] The function, which will be called for each found element before
 * setting its attributes. If the function returns false, the element is skipped. You may use this parameter to
 * do additional checks on the found elements.
 * @param {Function(HTMLElement)} [afterSet] The function, which will be called for each found element after
 * successfully setting the attributes. You may do additional operations on the found elements by giving a
 * proper function to this paramter.
 */
aV.aParser.retrieveElementsAndSetAttributes=function(queryStr, propertyName, attributeStr, beforeSet, afterSet)
{
	var elements=cssQuery(queryStr);
	
	if (!beforeSet)
		beforeSet=function(){return true;};
	
	for (var i=elements.length-1; i>=0; i--)
	{
		if (beforeSet(elements[i])===false)
			continue;
		
		if (
					aV.aParser.setElementAttributes(
						elements[i],
						propertyName,
						(attributeStr!='*')?attributeStr:elements[i].getAttribute(propertyName)
					)
					&&
					afterSet
				)
			afterSet(elements[i]);
	}	
};

/**
 * Assigns the elements' attributes rules from the ruleText
 * See {@link aV.aParser.retrieveElementsAndSetAttributes} for other parameters.
 * 
 * @param {String} ruleText The text which contains the rules in an external CSS file like structure.
 */
aV.aParser.assignAttributesFromText=function(ruleText, propertyName, beforeSet, afterSet)
{
	ruleText+="\n*[" + propertyName + "]{*}";
	ruleText=ruleText.replace(/\/\*.*\*\//g, '');
	var matcher=/([^\{]+)\s*\{\s*([^\}]+)\s*\}/g;
	
	var result, queryStr, attributeStr;
	while (result=matcher.exec(ruleText))
	{
		queryStr=result[1].trim();
		attributeStr=result[2].trim();
		
		aV.aParser.retrieveElementsAndSetAttributes(queryStr, propertyName, attributeStr, beforeSet, afterSet);
	}
};

/**
 * Assigns the elements' attributes using the rules from the given text file.
 * Loads the file and then calls the assignAttributesFromText to
 * parse its text content.
 * See {@link aV.aParser.retrieveElementsAndSetAttributes} for other parameters.
 * 
 * @method
 * @param {String} fileAddress The address of the file which contains the rules with a CSS file like structure.
 * @param {Boolean} [includeStyleTags=true] Tells the function that whether it should use the inline style tags for additional rules.
 */
aV.aParser.assignAttributesFromFile=function(fileAddress, propertyName, beforeSet, afterSet, includeStyleTags)
{
	aV.AJAX.makeRequest(
		'GET',
		fileAddress,
		'',
		function(requestObject)
		{
			var ruleText='';
			if (aV.AJAX.isResponseOK(requestObject))
				ruleText=requestObject.responseText;
			
			aV.aParser.assignAttributesFromText(ruleText, propertyName, beforeSet, afterSet);
			if (includeStyleTags || includeStyleTags===undefined)
				aV.aParser.assignAttributesFromStyleTag(propertyName, beforeSet, afterSet);
		}
	);
};

/**
 * Assigns the element's attributes using the inline style elements defined in the document.
 * The style elements' types should be "text/propertyName" for aV.aParser to recognize them.
 * propertyName in "text/propertyName" refers to the given parameter's value.
 * See {@link aV.aParser.retrieveElementsAndSetAttributes} for parameters.
 */
aV.aParser.assignAttributesFromStyleTag=function(propertyName, beforeSet, afterSet)
{
	var styleTags=cssQuery('style[type="text/' + propertyName + '"]');
	for (var i=0; i<styleTags.length; i++)
		aV.aParser.assignAttributesFromText(styleTags[i].innerHTML, propertyName, beforeSet, afterSet);
};

/**
 * @fileOverview A visual effects function library incloding some positioning functions.
 * @name Visual Effects and Functions Library
 *
 * @author Burak Yi餴t KAYA	byk@amplio-vita.net
 * @version 1.6
 *
 * @copyright &copy;2008 amplio-Vita under <a href="../license.txt" target="_blank">BSD Licence</a>
 */

if (!aV)
	throw new Error("aV namespace cannot be found.", "aV.main.visual.js@" + window.location.href);

if (!aV.Events)
	throw new Error("aV event manager library is not loaded.", "aV.main.visual.js@" + window.location.href);

/**
 * Represents a namespace, aV.Visual, for the new functions and global parameters of those functions.
 *
 * @namespace
 * @requires {@link aV.Events} (aV.main.events.js)
 * @param	{Integer} config.slideTreshold The maximum dimension difference between the current dimension and the target dimension to stop the sliding.
 * @param	{Float} config.slideDivisor The slide functions divide the remaining dimension difference to this number and add the result to the current dimension. The bigger this number gets the slower the slide gets.
 * @param	{Float [0,1]} config.fadeTreshold The maximum opacity difference between the current opacity and the target opacity to stop the fade.
 * @param	{Float} config.fadeDivisor The fade functions divide the remaining opacity difference to this number and add the result to the current opacity. The bigger this number gets the slower the fade gets.
 */
aV.Visual = {};

/**
 * Holds the configuration parameters.
 */
aV.config.Visual=
{
	slideTreshold: 2,
	slideDivisor: 4,
	fadeTreshold: 0.05,
	fadeDivisor: 4
};

/**
 * Holds the fixed elements recognized by the initEditables function.
 * Changing this properties value is not recommended.
 *
 * @type HTMLElementObject[]
 */
aV.Visual.fixedElements = [];

/**
 * Holds the user defined initialization functions.
 * Suitable for extending aV.Visual library.
 * <br />A developer can easly add his/her own function as in the example.	
 *
 * @type Function[]
 * @example
 * aV.Visual.initFunctions.add(
 * 	function()
 * 	{
 * 		aV.Visual.myPlugin={}
 * 		aV.Visual.myPlugin.version="1.0";
 * 		aV.Visual.myPlugin.foo=function()
 * 		{
 * 			alert("I'm a function of aV.Visual.myPlugin!");
 * 		}
 * 	}
 * );
 */
aV.Visual.initFunctions = [];

/**
 * Sets the given element's opacity to the given opacity value.
 * 
 * @param {HTMLElementObject} obj The HTML element ITSELF whose opacity will be changed.
 * @param {Float [0,1]} opacity The opacity value which the object's opacity will be set to.
 */
aV.Visual.setOpacity=function(obj, opacity)
{
	if (document.all) //if IE
		obj.style.filter="alpha(opacity=" + opacity*100 + ")"; //use filter-alpha
	else //if not IE
		obj.style.opacity=opacity; //use CSS opacity
};

/**
 * Tries to get the given element's opacity value.
 * <br /><b>IMPORTANT:</b> At the moment it can only get the opacity values defined in the object's style property.
 * @return {Float [0,1]} If a valid opacity value cannot be gathered, the default return value is 1.
 * @param {HTMLElementObject} obj The HTML element ITSELF whose opacity will tried to be gathered.
 */
aV.Visual.getOpacity=function(obj)
{
	var opacity;
	try
	{
		if (document.all) //if IE
			opacity=parseFloat(obj.style.filter.split('=')[1])/100; //extract the alpha value, then parse to float
		else //if not IE
			opacity=parseFloat(obj.style.opacity); //parse the opacity value to float
	}
	catch(e) //if any error occurs then,
	{
		opacity=1; //most probable opacity value is one
	}
	if (isNaN(opacity)) //or if opacity cannot be parsed to float, again
		opacity=1; //most probable opacity value is one
	return opacity;
};

/**
 * Fades the given HTML element, to the given opacity value with a slowing fade effect.
 *
 * @param {HTMLElementObject} obj The HTML element ITSELF which will be faded. It <b>must</b> have an ID.
 * @param {Float [0,1]} opacity The desired/target opacity to be faded to.
 * @param {Function(HTMLElementObject)}	[callback]	The function which will be called immediately after the fade operation is finished.
 */
aV.Visual.fade=function(obj, opacity, callback)
{
	if (obj.fadeTimer) //if there is an ongoing fade operation
	{
		clearTimeout(obj.fadeTimer); //cancel it
		obj.fadeTimer=undefined;
	}

	if (callback)
	{
		obj.fadeCallback=callback; //assign the callbackFunc to the object
	}
	
	var theOpacity=aV.Visual.getOpacity(obj); //get the object's current opacity
	if (Math.abs(theOpacity-opacity)>aV.config.Visual.fadeTreshold) //check if the difference between the current opacity and the desired opacity is above the defined treshold limit
	{
		aV.Visual.setOpacity(obj, theOpacity + (opacity - theOpacity)/aV.config.Visual.fadeDivisor); //calculate and set the new opacity
		obj.fadeTimer=setTimeout("aV.Visual.fade(document.getElementById('" + obj.id + "'), " + opacity + ")", 25); //set new instance to be called after 25ms
	}
	else //if the difference is smaller or equal to the defined treshold
	{
		aV.Visual.setOpacity(obj, opacity); //set the opacity to the desired value for an exact match
		if (obj.fadeCallback) //if a callbackFunction is assigned
		{
			obj.fadeCallback(obj); //call it
			obj.fadeCallback=undefined;
		}
	}
};

/**
 * Fades the first element to invisiblity and then fades the second element to full opacity.
 *
 * @param	{HTMLElementObject}	fromObj	The HTML element which will be FADED OUT.
 * @param	{HTMLElementObject}	toObj	The HTML element which will be FADED IN.
 * @param	{Function(HTMLElementObject, HTMLElementObject)}	[callback]	The function which will be called immediately after the whole fade operation is finished. The first parameter passed to the function is fromObj and the second parameter is toObj.
 */
aV.Visual.fadeFromOneToOne=function(fromObj, toObj, callback)
{
	aV.Visual.fade(fromObj, //fade the fromObj
				0, //to 0 opacity(invisible)
				function(obj)
				{
					obj.style.display="none"; //and when it becomes invisible, make its display none to consume no visual space
					toObj.style.display=""; //and make the toObj's display property "" to force it to the default value
					aV.Visual.fade(toObj, //then fade the toObj
								1, //to full opacity(fully visible)
								function(obj)
								{
									if (window.onresize)
										window.onresize({type: "resize"}); //there might be window size change so if a function is assigned to window.onresize and on scroll, call them.
									if (callback) //if a callbackFunc assigned
										callback(fromObj, toObj) //call it with giving the fromObj and toObj as its parameters
								}
								);
				}
				);
};

/**
 * Slides the given HTML element to the given dimension with a combined fade efect. The effects slow down non-linearly.
 *
 * @param	{HTMLElementObject}	obj	The HTML element ITSELF which will be slided. It *MUST* have an ID.
 * @param	{Integer}	newDimension	The desired/target height/width to be slided to.
 * @param	{Integer [-1,1]}	opcDirection	The opacity change direction identifier. If it is positive the opacity INCREASES with the continuing slide operation and vice versa.
 * @param	{Boolean}	horizontalSlide	Defines if the newDimension is a height value or a width value. (Width if true)
 * @param	{Function(HTMLElementObject)}	[callback]	The function which will be called immediately after the slide operation is finished.
 */
aV.Visual.fadeNSlide=function(obj, newDimension, opcDirection, horizontalSlide, callback)
{
	var propertyName=(horizontalSlide)?"Width":"Height";
	
	if (obj.slideTimer) //if there is an ongoing slide
	{
		clearTimeout(obj.slideTimer); //cancel it
		obj.slideTimer=undefined;
	}
		
	if (!obj["old" + propertyName])
		obj["old" + propertyName]=(obj.style[propertyName.toLowerCase()])?parseInt(obj.style[propertyName.toLowerCase()]):obj["offset" + propertyName]; //set the old height if available forum CSS, and if not from the offsetHeight property.

	if (callback)
		obj.slideCallback=callback; //assign the callbackFunc to object's slideCallback property

	var currentDimension=(obj.style[propertyName.toLowerCase()])?parseInt(obj.style[propertyName.toLowerCase()]):obj["offset" + propertyName]; //get the current height, seperate from the above *oldHeight*. This is needed for the iteration.
  if (Math.abs(Math.round(currentDimension-newDimension))>aV.config.Visual.slideTreshold) //check if the difference between the *currentDimension* and the desired height is above the the defined treshold value
	{
		obj.style[propertyName.toLowerCase()]=Math.round(currentDimension + (newDimension - currentDimension)/aV.config.Visual.slideDivisor) + "px"; //decrease the difference by difference/4 for a non-linear and a smooth slide
		
		var opacity=(parseInt(obj.style[propertyName.toLowerCase()])-obj["old" + propertyName])/(newDimension-obj["old" + propertyName]); //calculate the opacity by getting the ratio of the *currentDimension* and the desired height
		if (opcDirection<0) //if direction is negative, substitude the opacity from 1, since 1 is the maximum opacity
			opacity=1-opacity;
		aV.Visual.setOpacity(obj, opacity); //set the calculated opacity
		obj.slideTimer=setTimeout("aV.Visual.fadeNSlide(document.getElementById('" + obj.id + "'), " + newDimension + ", " + opcDirection + ", " + horizontalSlide + ");", 25); //set new instance, which will be called after 25ms
	}
	else //if the diffrence is below the defined treshold, time to stop :)
	{
		obj.style[propertyName.toLowerCase()]=newDimension + "px"; //set the height to the desired height for an exact match
		aV.Visual.setOpacity(obj, (newDimension<obj["old" + propertyName])?0:1); //set opacity
		obj["old" + propertyName]=undefined;
		if (obj.slideCallback) 
		{
			obj.slideCallback(obj); //call the callbackFunc if it is defined
			obj.slideCallback=undefined;
		}
	}
	if (window.onscroll)
		window.onscroll({type: "scroll"}); //there might be a scroll change so if a function is assigned to window.onscroll, call it.
};

/**
 * Moves the given object to the given postion with a slowing move effect.
 *
 * @param	{HTMLElementObject}	obj	The HTML element which will be moved.
 * @param	{Integer | false}	[xPos]	The target X coordinate of the given HTML element. If it is given as false, the X coordinate is not changed.
 * @param	{Integer | false}	[yPos]	The target Y coordinate of the given HTML element. If it is given as false, the Y coordinate is not changed.
 * @param	{Function(HTMLElementObject)}	[callback]	The function which will be called immediately after the moving operation is finished.
 */
aV.Visual.move=function(obj, xPos, yPos, callback)
{
	var timerNeeded=false; //this variable actually defines that if there is way to go to the position or not :)
	if (obj.moveTimer) //if there is an ongoing move operation
	{
		clearTimeout(obj.moveTimer); //cancel it
		obj.moveTimer=undefined;
		if (callback && obj.moveCallback) //if a callBackFunction is assigned
			obj.moveCallback(obj); //call it
	}
		
	if (callback)
		obj.moveCallback=callback; //assign the callBackFunc to the object
	
	 //get the object's current position
	var currentXPos=parseInt(obj.style.left) | 0;
	var currentYPos=parseInt(obj.style.top) | 0;
	
	if (xPos===false) //a forced type+value check is need to prevent this statement become true if xPos is equal to 0
		xPos=currentXPos;
		
	if (yPos===false)
		yPos=currentYPos;
		
	//for x-position
	if (Math.abs(Math.round(currentXPos-xPos))>aV.config.Visual.slideTreshold) //check if the difference between the current x-position and the desired *xPos* is above the defined treshold limit
	{
		obj.style.left=Math.round(currentXPos + (xPos - currentXPos)/aV.config.Visual.slideDivisor) + "px"; //calculate and set the new x-position
		timerNeeded=true;
	}
	else //if the difference is smaller or equal to the defined treshold
		obj.style.left=xPos + "px"; //set the x-position to the desired value for an exact match
	
	//for y-position
	if (Math.abs(currentYPos-yPos)>aV.config.Visual.slideTreshold) //check if the difference between the current y-position and the desired *yPos* is above the defined treshold limit
	{
		obj.style.top=Math.round(currentYPos + (yPos - currentYPos)/aV.config.Visual["slideDivisor"]) + "px"; //calculate and set the new y-position
		timerNeeded=true;
	}
	else //if the difference is smaller or equal to the defined treshold
		obj.style.top=yPos + "px"; //set the y-position to the desired value for an exact match

	if (timerNeeded)
		obj.moveTimer=setTimeout("aV.Visual.move(document.getElementById('" + obj.id + "'), " + xPos + ", " + yPos + ")", 25); //set new instance to be called after 25ms
	else if (obj.moveCallback) //if a callBackFunction is assigned
	{
		obj.moveCallback(obj); //call it
		obj.moveCallback=undefined;
	}
};

/**
 * This function is called whenever a scroll or resize event is occured. It determines the fixed elements' appropriate new positions and calls "moveElement" to set them.
 * <br />Can be called manually to ensure all the fixed elements are in correct place.
 */
aV.Visual.setFixedElementPositions=function()
{
	//below variable definitons are only for not to call the functions repedeatly in the for loop
	var visiblePageLeftPosition=aV.Visual.scrollLeft();
	var visiblePageTopPosition=aV.Visual.scrollTop();
	var visiblePageWidth=aV.Visual.clientWidth();
	var visiblePageHeight=aV.Visual.clientHeight();	
	var xPosTemp, yPosTemp;
	for (var i=aV.Visual.fixedElements.length-1; i>=0; i--) //walk throught the fixed elements
	{
		if (typeof(aV.Visual.fixedElements[i].xOffset)=="number")
			if (aV.Visual.fixedElements[i].xOffset>=0)
				xPosTemp=visiblePageLeftPosition + aV.Visual.fixedElements[i].xOffset;
			else
				xPosTemp=visiblePageLeftPosition + visiblePageWidth + aV.Visual.fixedElements[i].xOffset - aV.Visual.fixedElements[i].offsetWidth;
		else
			xPosTemp=false;
		
		if (typeof(aV.Visual.fixedElements[i].yOffset)=="number")
			if (aV.Visual.fixedElements[i].yOffset>=0)
				yPosTemp=visiblePageTopPosition + aV.Visual.fixedElements[i].yOffset;
			else
				yPosTemp=visiblePageTopPosition + visiblePageHeight + aV.Visual.fixedElements[i].yOffset - aV.Visual.fixedElements[i].offsetHeight;
		else
			yPosTemp=false;
			
		aV.Visual.move(aV.Visual.fixedElements[i], xPosTemp, yPosTemp); //move them to the appropriate positions
	}
};

/**
 * This function initialises the "fixed positioned elements" and adds them to the <a href="#aV.Visual.fixedElements">fixedElements</a> array.
 * <br />It also adds the <a href="#aV.Visual.setFixedElementPositions">setFixedElementPositions</a> function to window.onresize and window.onscroll event lists.
 * <br />The mentioned elements <b>must</b> have their ID properties set.
 * <br />
 * <br />The so called "fixed positioned elements" are the ones which has an <b>xOffset</b> or a <b>yOffset</b> property(or both of them).
 * <br />These properties define the elements' distance from the page's edges. A negative offset means the offset is measured from the opposite edge. (i.e. xOffset="-10" means 10 pixels from right side)
 *
 * @example
 * &lt;div id="cart" xOffset="-10" yOffset="-10"&gt;<br />I'm your shopping cart and I stay always at the top right corner of your window with a 10px padding<br />&lt;/div&gt;
 */
aV.Visual.initFixedElements=function()
{
	aV.Visual.fixedElements=[];
	var list=document.getElementsByTagName('*'); //get all the elements
	for (var i=list.length-1; i>=0; i--) //walk all the elements
	{
		xOffsetTemp=list[i].getAttribute("xOffset");
		yOffsetTemp=list[i].getAttribute("yOffset");		
		if (xOffsetTemp || yOffsetTemp) //if it is a "fixed-position" element
		{
			aV.Visual.fixedElements.push(list[i]); //add the element to the list
			//parse the string value into integer at the beginning to make the scroll events faster
			if (xOffsetTemp)
				list[i].xOffset=parseInt(xOffsetTemp);
			if (yOffsetTemp)
				list[i].yOffset=parseInt(yOffsetTemp);
			list[i].style.position="absolute"; //make sure the elements positioning is absolute
		}
	}
	//assign the watcher setFixedElementPositions function to the scroll and resize events
	aV.Events.add(window, "resize", aV.Visual.setFixedElementPositions);
	aV.Events.add(window, "scroll", aV.Visual.setFixedElementPositions);
	//call the setFixedElementPositions function to set the initial positions of the elements when the page is loaded
	aV.Visual.setFixedElementPositions();
};

/** <a href="http://www.softcomplex.com/docs/get_window_size_and_scrollbar_position.html">External</a> page&scroll size functions */

/**
 * Returns the internal usable width of the page.
 *
 * @return	{Integer}
 */
aV.Visual.clientWidth=function()
{
	return aV.Visual._filterResults (
		window.innerWidth ? window.innerWidth : 0,
		document.documentElement ? document.documentElement.clientWidth : 0,
		document.body ? document.body.clientWidth : 0
	);
};

/**
 * Returns the internal usable height of the page.
 *
 * @return	{Integer}
 */
aV.Visual.clientHeight=function()
{
	return aV.Visual._filterResults (
		window.innerHeight ? window.innerHeight : 0,
		document.documentElement ? document.documentElement.clientHeight : 0,
		document.body ? document.body.clientHeight : 0
	);
};

/**
 * Returns the scroll offset of the page from the left.
 *
 * @return	{Integer}
 */
aV.Visual.scrollLeft=function()
{
	return aV.Visual._filterResults (
		window.pageXOffset ? window.pageXOffset : 0,
		document.documentElement ? document.documentElement.scrollLeft : 0,
		document.body ? document.body.scrollLeft : 0
	);
};

/**
 * Returns the scroll offset of the page from the top.
 *
 * @return	{Integer}
 */
aV.Visual.scrollTop=function()
{
	return aV.Visual._filterResults (
		window.pageYOffset ? window.pageYOffset : 0,
		document.documentElement ? document.documentElement.scrollTop : 0,
		document.body ? document.body.scrollTop : 0
	);
};

/**
 * Filters the given values for a cross-browser compatibility.
 *
 * @private
 * @return	{Integer}
 */
aV.Visual._filterResults=function(n_win, n_docel, n_body)
{
	var n_result = n_win ? n_win : 0;
	if (n_docel && (!n_result || (n_result > n_docel)))
		n_result = n_docel;
	return n_body && (!n_result || (n_result > n_body)) ? n_body : n_result;
};
/** End of external code */

/** External code from unknown author, if you know the author, please notify me */

/**
 * Gets the CSS rule element whose name is given with ruleName parameter or deletes it providing to the deleteFlag's state.
 *
 * @return	{CSSRuleElementObject}
 * @param	{String}	ruleName	The name of the CSS rule which will be returned.
 * @param	{Boolean}	[deleteFlag]	Set to true if you want to delete the CSS rule whose name is given in the ruleName parameter.
 */
aV.Visual.getCSSRule=function(ruleName, deleteFlag)
{
	if (document.styleSheets)
	{
		for (var i=0; i<document.styleSheets.length; i++)
		{
			var styleSheet=document.styleSheets[i];
			var ii=0;
			var cssRule=false;
			do
			{
				if (styleSheet.cssRules)
					cssRule = styleSheet.cssRules[ii];
				else
					cssRule = styleSheet.rules[ii];
				if (cssRule)
				{
					if (cssRule.selectorText==ruleName)
					{
						if (deleteFlag)
						{
							if (styleSheet.cssRules)
								styleSheet.deleteRule(ii);
							else
								styleSheet.removeRule(ii);
							return true;
						}
						else
							return cssRule;
					}
				}
				ii++;
			}
			while (cssRule)
		}
	}
	return false;
};
/** end of unknown author's external code */


/**
 * Gathers the REAL position of the given HTML element.
 *
 * @private
 * @deprecated Use {@link aV.Visual.getElementPositionX} and {@link aV.Visual.getElementPositionY} instead.
 * @return	{Integer}
 * @param	{HTMLElementObject}	element	The HTML element whose position to be gathered.
 * @param	{Boolean}	[xPosition]	Set true to get the X coordinate, false for Y coordinate.
 */
aV.Visual._getElementPosition=function(element, xPosition)
{
	if (!element)
		return;
	var axis=(xPosition)?'Left':'Top';
	var position = 0;

	do
	{
		position+=element['offset' + axis];
	}
	while (element=element.offsetParent)
	return position;
};

/**
 * Gets the x position of the element.
 *
 * @return	{Integer}
 * @param	{HTMLElementObject}	element	The HTML element whose x position to be gathered.
 */
aV.Visual.getElementPositionX=function(element)
{
	return aV.Visual._getElementPosition(element, true);
};

/**
 * Gets the y position of the element.
 * @return	{Integer}
 * @param	{HTMLElementObject}	element	The HTML element whose y position to be gathered.
 */
aV.Visual.getElementPositionY=function(element)
{
	return aV.Visual._getElementPosition(element, false);
};

/**
 * Initializes the aV.Visual system.
 * Loops through the initFunctions array and calls every function in the array.
 * After the loop is done, calls <a href="#aV.Visual.initFixedElements">initFixedElements</a>.
 * Attached to the window.onload event automatically.
 *
 * @method
 */
aV.Visual.init=function()
{
	aV.Visual.initFunctions.push(aV.Visual.initFixedElements);
	for (var i=0, max=aV.Visual.initFunctions.length; i<max; i++)
		aV.Visual.initFunctions[i]();
};

aV.Events.add(window, 'load', aV.Visual.init);

/**
 * @fileOverview	Allows non obtrusive in-place-editing functionality for both images and text based elements.
 * @name aV.QuickEdit
 *
 * @author	Burak Yi餴t KAYA	byk@amplio-vita.net
 * @version	2.1.2
 *
 * @requires	<a href="http://amplio-vita.net/JSLib/js/aV.ext.string.js">aV.ext.string.js</a>
 * @requires	<a href="http://amplio-vita.net/JSLib/js/aV.main.events.js">aV.main.events.js</a>
 * @requires	<a href="http://amplio-vita.net/JSLib/js/aV.main.ajax.js">aV.main.ajax.js</a>
 * @requires	<a href="http://amplio-vita.net/JSLib/js/aV.main.aParser.js">aV.main.aParser.js</a> 	
 * @requires	<a href="http://amplio-vita.net/JSLib/js/aV.main.visual.js">aV.main.visual.js</a>
 * @copyright &copy;2008 amplio-Vita under <a href="../license.txt" target="_blank">BSD Licence</a>
 */

if (!aV)
	throw new Error("aV namespace cannot be found.", "aV.plg.quickEdit.js@" + window.location.href);

if (!aV.Events)
	throw new Error("aV event manager library is not loaded.", "aV.plg.quickEdit.js@" + window.location.href);

if (!aV.AJAX)
	throw new Error("aV AJAX functions library is not loaded.", "aV.plg.quickEdit.js@" + window.location.href);

if (!aV.aParser)
	throw new Error("aV aParser functions library is not loaded.", "aV.plg.quickEdit.js@" + window.location.href);

if (!aV.Visual)
	throw new Error("aV visual functions library is not loaded.", "aV.plg.quickEdit.js@" + window.location.href);

/**
 * Represents a namespace, aV.QuickEdit, for the new functions and global parameters of those functions.
 *
 * @namespace
 * @config {String} uploadImgPath The path to the image which will be shown while uploading a file via an upload box.
 * @config {String} imgUploadTitle The default upload box title for image replacements.
 * @config {String} imgUploadError The error message which will be showed when an error is occured while uploading the new image.
 * @config {String} textEditError The error message which will be showed when an error is occured while uploading the new text content.
 * @config {String} ruleFile Path to the external file which contains the rule definitons for editable items.
 * @config {Boolean} useInfoBox The script will try to use the InfoBox extension(if exists) to display messages instead of <b>alert</b> function.
 * @config {String[]} forbiddenTags The tag names in uppercase which should not be assigned for quickEdit in any case.
 */
aV.QuickEdit = {};

aV.config.QuickEdit=
{
	uploadImgPath: "images/uploading.gif",
	imgUploadTitle: "Please select new image",
	imgUploadError: "An error occurred while uploading the new image. Please try again.",
//	textEditError: "An error occurred while changing the value. Please try again.",
	ruleFile: "editableRules.txt",
	useInfoBox: false,
	forbiddenTags: ["INPUT", "SELECT", "OPTION", "TEXTAREA", "FORM", "HR", "BR", "IFRAME"]
};

/**
 * Used internally to assign unique id's to the created upload boxes.
 * <br />You should <b><u>never</u></b> change this value.
 *
 * @type integer
 */
aV.QuickEdit.uploadBoxCount=0;

/**
 * Creates a tiny little upload box which has the class name <b>uploadContainer</b>.
 * It asynchronously uploads selected file immediately after the user have selected it.
 *
 * @return {HTMLDivElementObject} The object reference to the created upload box div.
 * @param {String} titleText	The title of the upload box.
 * @param {String} postAdress	The adress of the server-side page, where the file will be uploaded.
 * @param {String} params	A "&" delimited string which contains the parameters which will be passed
 * to the server-side page. Just like the GET paramters of a page, the parameter values should be URIEncoded.
 * <br /><b>Note: </b>The last item should not be a name-value pair. Instead, it should only have the name of the file variable.
 * <br />An example params string will be like this: <br />
 * <br />var1=hello%20world&var2=hello%20again&theFileVar
 * @param {Function(HTMLDivElementObject, String)} [callBackFunc] The function which is called when the upload process is finished.
 * It should take the parent object of the uploadBox div, which is the same element what the createUploadBox function returns,
 * as its first paramter. The text result of the server-side page's response, which is defined in <b>postAddress</b> parameter, as its second parameter.
 * <br /> If this function returns false, the upload box will remain and if this function returns nothing or true the upload box will dissappear after
 * the POST operation is completed.
 * <br />The upload box will automatically dissappear if callBackFunction is not assigned also.
 */
aV.QuickEdit.createUploadBox=function(titleText, postAddress, params, callBackFunc)
{
	var containerDiv=document.createElement("div"); //create the container div, which contains the necessary elements for the upload box.
	containerDiv.className="uploadContainer"; //set the div's class to uploadContainer both for CSS and identification
	containerDiv.id="uplContainer" + aV.QuickEdit.uploadBoxCount; //assign the unique upload div id
	containerDiv.callBackFunc=callBackFunc; //define a new property for the containerDiv for storing the *callBackFunc*
	
	//start defining the onload function of the upcoming iframe in text format for compatibility with IE
	var onloadFunc="var responseText=(this.contentDocument)?this.contentDocument.body.innerHTML:this.contentWindow.document.body.innerHTML;if(!responseText)return;var destroyContainer=true;if(this.parentNode.callBackFunc)destroyContainer=this.parentNode.callBackFunc(this.parentNode,responseText);if(destroyContainer)setTimeout('aV.QuickEdit._destroyUploadBox(document.getElementById(\\'" + containerDiv.id + "\\'));', 0);";
	
	//prepare the inner visual structure of the uploadBox container div - this part might be customized
	var inHTML='<div class="uploadTitle" style="float: left; clear: both; width: 100%">';
	inHTML+='<div class="uploadTitleText">' + titleText + '</div>';
	inHTML+='<div class="uploadCloseButton" onclick="aV.QuickEdit._destroyUploadBox(this.parentNode.parentNode)"><sup>x</sup></div>';
	inHTML+='</div>';
	
	//add the necessary hidden iframe code
	inHTML+='<iframe id="uploadIframe' + aV.QuickEdit.uploadBoxCount + '" name="uploadIframe' + aV.QuickEdit.uploadBoxCount + '" style="display:none" src="about:blank" onload="' + onloadFunc + '"></iframe>';
	
	//add the necessary form code to the container div. Keeping this part as is, is strongly recommended but might be customized
	inHTML+='<form style="float: left; width: 100%" action="' + postAddress + '" id="uploadForm' + aV.QuickEdit.uploadBoxCount + '" method="post" enctype="multipart/form-data" target="uploadIframe' + aV.QuickEdit.uploadBoxCount + '">';
	
	try
	{
		eval("params=" + params);
	}
	catch (error)
	{
		params=params;
	}
	
	var paramList=params.split('&');
	for (var i=0; i<paramList.length-1; i++)
	{
		var tempArray=paramList[i].split('=');
		inHTML+='<input type="hidden" name="' + tempArray[0] + '" value="' + tempArray[1] + '" />';
	}
	//inHTML+='<input type="hidden" name="MAX_FILE_SIZE" value="500000" />';
	inHTML+='<input type="file" name="' + paramList[paramList.length-1] + '" onchange="if(this.value){this.form.submit();this.disabled=true;document.getElementById(\'uploadImg' + aV.QuickEdit.uploadBoxCount + '\').style.display=\'block\'}" />';
	//place the hidden "in-progress" image at the bottom of the form, might be customized except the id part
	inHTML+='<center><img src="' + aV.config.QuickEdit["uploadImgPath"] + '" id="uploadImg' + aV.QuickEdit.uploadBoxCount + '" style="display: none; margin: 1px;" /></center>';
	inHTML+='</form>';
	//assign the dynamically generated HTML code to the container div's innerHTML property
	containerDiv.innerHTML=inHTML;
	document.body.appendChild(containerDiv); //add the container div to the document
	aV.QuickEdit.uploadBoxCount++;
	return containerDiv; //return the created, final container div as an object
};

/**
 * Destroys the given uploadbox (either by id or directly the object) safely.
 * <br />Should not be used directly by the user.
 *
 * @method
 * @private
 * @deprecated Used internally by <a href="#aV.QuickEdit.createUploadBox">createUploadBox</a>
 * @param {HTMLDivElementObject | String} uploadBox The id or the object referance of the upload box, which will be destroyed.
 */
aV.QuickEdit._destroyUploadBox=function(uploadBox)
{
	var uploadBox;
	if (typeof(uploadBox)=='string')
		uploadBox=document.getElementById(uploadBox);
	if (!uploadBox) return false;
	if (uploadBox.callerElement)
	{
		uploadBox.callerElement.aVquickEdit.active=false;
		if (uploadBox.callerElement.onmouseout) uploadBox.callerElement.onmouseout({type: "mouseout", target: uploadBox.callerElement});
	}
	document.body.removeChild(uploadBox);
	//aV.QuickEdit.uploadBoxCount--;
	return true;
};

/**
 * Creates a special uploadBox in the middle of the image element given by <b>imgElement</b> parameter
 * and uploads the image to the <b>uploadAdress</b> using the uploadBox system which is explained in the
 * <a href="#aV.QuickEdit.createUploadBox">createUploadBox</a>.
 *
 * @method
 * @private
 * @deprecated Direct call to this function is not suggested, see <a href="#aV.QuickEdit.init">init</a> for details.
 * @param {HTMLImageElementObject} imgElement The object reference of the image which will be dynamically replaced.
 * @param {String} uploadAddress The address of the server-side sccripting page, where the image will be uploaded(POSTed)
 * @param {Strimg} params The additional parameters while posting the image.
 * See <a href="#aV.QuickEdit.createUploadBox">createUploadBox</a>'s <b>params</b> paramter for further details.
 * @param {String} [title] The title of the upload box created for the replacement operation of the image.
 * If not given, config["imgUploadTitle"]is used.
 */
aV.QuickEdit._changeImage=function(imgElement, uploadAddress, params, title)
{
	/*
	if (typeof(imgElement)=='string')
		imgElement=document.getElementById(imgElement);
	*/
	
	if (imgElement.aVquickEdit.active) //if there is already an uploadBox, return false
		return false;
				
	if (!title) //if no spesific title is defined, use the default one
		title=aV.config.QuickEdit["imgUploadTitle"];
	var uplBox=aV.QuickEdit.createUploadBox(title, uploadAddress, params, aV.QuickEdit._imgLoaded); //create an upload box, just as we want :)
	imgElement.aVquickEdit.active=true; //set the image's aVquickEdit.active mode to true, to indicate it now has an uploadBox
	uplBox.callerElement=imgElement; //set the uploadBox's callerElement as our image, for further use
	uplBox.style.width="200px";
	//position the upload box, in the middle of the image
	uplBox.style.top=Math.round(aV.Visual.getElementPositionY(imgElement) + (imgElement.offsetHeight - uplBox.offsetHeight)/2) + "px";
	uplBox.style.left=Math.round(aV.Visual.getElementPositionX(imgElement) + (imgElement.offsetWidth - uplBox.offsetWidth)/2) + "px";	
};

/**
 * Used internally by <a href="#aV.QuickEdit._changeImage">_changeImage</a> when the image is uploaded.
 *
 * @private
 * @deprecated
 * @return {Boolean} Returns true if the new image is uploaded and the response is in the correct format, false otherwise.
 * @param {HTMLDivElementObject} container The upload box container element's object referance
 * @param {String} responseText The response text, returned from the server-sided-script file
 */

aV.QuickEdit._imgLoaded=function(container, responseText)
{
	responseText=responseText.stripHTML().trim();
	if (responseText && responseText.substr(0, 5)=="path=")
	{
		//if there *is* a response text and it starts with "path=" prefix,
		//which indicates a successfull upload operation and gives us the new image's http adress
		//we will set the given adress to the image's src property,
		//but if they are the same(image.src and the new path), browsers will continue to use
		//the cache. To prevent this, we add a dummy get parameter which is actually the current
		//time, which forces a refresh.
		var now=new Date();
		container.callerElement.src=responseText.substring(5) + '?' + now.getTime();
		return true;
	}
	else
	{
		//if the responseText is not in the format we expected, raise an error and inform the user
		if (aV.config.QuickEdit["useInfoBox"])
			aV.Visual.infoBox.show(aV.config.QuickEdit["imgUploadError"]);
		else
			//alert(aV.config.QuickEdit["imgUploadError"]);
		//alert(responseText);
		//enable the "file" input box again for a retry
		var inputAreas=container.getElementsByTagName("input");
		for (var i=0; i<inputAreas.length; i++)
			inputAreas[i].disabled=false;
		delete inputAreas;
		
		//reset the form and hide the "in-progress" image
		container.getElementsByTagName("form")[0].reset();
		container.getElementsByTagName("img")[0].style.display="none";
		return false;
	}
};

/**
 * This function is assigned to all editable elements' onMouseOver event by <a href="#aV.QuickEdit.init">init</a>
 * <br />Might be customized, but it is not suggested.
 *
 * @method
 * @private
 * @deprecated It is an event handler, do not call directly
 * @param {EventObject} event
 */
aV.QuickEdit._editableElementHover=function(event)
{
	var element=event.target;
	if (!element.aVquickEdit)
		return;

	if(eval(element.aVquickEdit.condition))
	{//evaluate the given editing condition and if it is true, continue the operation.
		element.className='editable'; //set the class to the general "editable" class
		if (element.aVquickEdit.fade!=null) //if there is a "fade" variable, fade the element
			aV.Visual.fade(element, element.aVquickEdit.fade);
	}	
};

/**
 * This function is assigned to all editable elements' onMouseOut event by <a href="#aV.QuickEdit.init">init</a>
 * <br />Might be customized, but it is not suggested.
 *
 * @method
 * @private
 * @deprecated It is an event handler, do not call directly.
 * @param {EventObject} event
 */
aV.QuickEdit._editableElementMouseOut=function(event)
{
	var element=event.target; //get the element from event object
	if (!element.aVquickEdit)
		return;
	
	if(!element.aVquickEdit.active) //if the element is not clicked (or being edited)
	{
		if (element.aVquickEdit.fade!=null) //if fading assigned, return to opaque mode
			aV.Visual.fade(element, 1);
		element.className=element.baseClass; //revert the class name to its original
	}
};

/**
 * This function is assigned to all editable elements' onClick event by <a href="#aV.QuickEdit.init">init</a>
 * <br />Might be customized, but it is not suggested.
 *
 * @method
 * @private
 * @deprecated It is an event handler, do not call directly.
 * @param {EventObject} event
 */
aV.QuickEdit._editableElementClick=function(event)
{
	var element=event.target;
	if (!element.aVquickEdit)
		return;
	
	if(element.className=='editable')
	{//if editing condition is satisfied on the mouseover event and the element has "editable" as its className, start editing
		if (element.tagName=="IMG") //if the element is an image, use the "changeImage" function
			aV.QuickEdit._changeImage(element, element.aVquickEdit.action, element.aVquickEdit.params);
		else //else if the element is a text-based element, use the regular "editLabel" function
			aV.QuickEdit._editLabel(element);
	}	
};

/**
 * This function is used to send the newly edited element's data to the server-sde-scripting page
 * and to set the new data if it is confirmed by the <i>action</i> page.
 *
 * @method
 * @private
 * @deprecated Used internally, should not be called directly.
 * @param {HTMLElementObject} nameContainer
 */
aV.QuickEdit._setEditedValue=function(nameContainer)
{
	var labelObject=nameContainer.parentNode;
	var completedFunction=function(requestObject)
	{
		if (parseInt(requestObject.responseText)>0) //expecting "1" from the response page
		{
			var newName=nameContainer.value;
			labelObject.innerHTML="";
			labelObject.appendChild(document.createTextNode(newName));
			labelObject.innerHTML=labelObject.innerHTML.LBtoBR();

			labelObject.aVquickEdit.active=false;
			labelObject.onmouseout({type: "mouseout", target: labelObject});
		}
		else
		{
			if (aV.config.QuickEdit["useInfoBox"])
				aV.Visual.infoBox.show(aV.config.QuickEdit["textEditError"]);
			else
				//alert(aV.config.QuickEdit["textEditError"]);
			nameContainer.disabled=false;
		}
	};
	
	var loadFunction=function()
	{
		nameContainer.disabled=true;
	};
	
	var params;
	try
	{
		eval("params=" + labelObject.aVquickEdit.params);
	}
	catch (error)
	{
		params=labelObject.aVquickEdit.params;
	}
	
	aV.AJAX.makeRequest(
		"POST",
		labelObject.aVquickEdit.action,
		labelObject.aVquickEdit.params + '=' + encodeURIComponent(nameContainer.value.LBtoBR()),
		completedFunction,
		loadFunction
	);
};

/**
 * Starts the editing processes of text based elements.
 *
 * @method
 * @private
 * @deprecated Used internally, should not be used directly.
 * @param {HTMLElementObject} labelObject
 */
aV.QuickEdit._editLabel=function(labelObject)
{
	if (labelObject.aVquickEdit.active)
		return;
	
	var editBox;
	
	switch(labelObject.aVquickEdit.type)
	{
		case 'select':
			if (typeof labelObject.aVquickEdit.selectValues == 'string') 
			{
				try 
				{
					eval('labelObject.aVquickEdit.selectValues=' + labelObject.aVquickEdit.selectValues + ';');
				} 
				catch (error) 
				{
					labelObject.aVquickEdit.selectValues = labelObject.aVquickEdit.selectValues;
				};
			}
			else if (typeof labelObject.aVquickEdit.selectValues=='undefined')
				return false;
			editBox=document.createElement("SELECT");			
			for (var i=0; i<labelObject.aVquickEdit.selectValues.length; i++)
				editBox.add(new Option(labelObject.aVquickEdit.selectValues[i], labelObject.aVquickEdit.selectValues[i]), undefined);
			break;
		case 'textarea':
			editBox=document.createElement("TEXTAREA");
			editBox.style.width=(labelObject.clientWidth>79)?(labelObject.clientWidth - 4) + "px":'auto';
			editBox.style.height=(labelObject.scrollHeight - 4) + "px";
			break;
		default: 
			editBox=document.createElement("INPUT");
	};

	if (labelObject.aVquickEdit.type!='select')
	{
		editBox.onkeydown=function(e)
		{
			var key = e ? e.which : window.event.keyCode;
			if (key==27)
			{
				this.value=this.originalValue;
				this.onblur();
			}
			else if (this.tagName=='INPUT' && key==13)
			{
				this.onblur();
			}
			else if (this.tagName=='TEXTAREA' && parseInt(this.style.height)<this.scrollHeight)
			{
				this.style.height=Math.max(this.scrollHeight - 2, 20) + "px";
			}
			
			return true;
		};
	}
	
	editBox.onblur=function() 
	{
		if (this.value==this.originalValue || !this.value)
		{			
			labelObject.innerHTML=labelObject.oldHTML;
			labelObject.aVquickEdit.active=false;
			labelObject.onmouseout({type: "mouseout", target: labelObject});
		}
		
		else
		{
			aV.QuickEdit._setEditedValue(this);
			this.disabled=true;
		}
		
	};
	
	labelObject.oldHTML=labelObject.innerHTML;
	labelObject.innerHTML=labelObject.innerHTML.BRtoLB();

	if (labelObject.firstChild && labelObject.firstChild.nodeValue)
		editBox.value=labelObject.firstChild.nodeValue;
	else if (labelObject.innerText)
		editBox.value=labelObject.innerText;
	else
		editBox.value='';

	editBox.originalValue=editBox.value;

	labelObject.innerHTML="";

	labelObject.appendChild(editBox);
	labelObject.aVquickEdit.active=true;
	
//	editBox.className="editLabel";
	editBox.focus();
	if (editBox.select)
		editBox.select();
};

/**
 * Returns true if the element's TAG is not in the config.forbiddenTags list.
 * 
 * @private
 * @deprecated Used internally for element initialization.
 * @return {Boolean}
 * @param {HTMLObject} element
 */
aV.QuickEdit._checkElement=function(element)
{
	for (var i=aV.config.QuickEdit.forbiddenTags.length-1; i>=0; i--)
		if (element.tagName==aV.config.QuickEdit.forbiddenTags[i])
			return false;
	return true;
};

/**
 * Assigns the necessary functions to the editable element which
 * is gathered and whose attributes are set by aV.aParser.setElementAttributes
 * 
 * @private
 * @deprecated Used internally, might be used if a new element is dynamically added to the page and it should be editable.
 * @method
 * @param {HTMLElementObject} element The element whose attributes will be set.
 * @param {String} attributeStr The string which containts the editability properties.
 */
aV.QuickEdit._setEditableElement=function(element)
{
	element.baseClass=element.className; //note its current class for roll back as baseClass
	aV.Events.add(element, "mouseover", aV.QuickEdit._editableElementHover); //assign the "private" editableElementHover function to onmouseover event
	aV.Events.add(element, "mouseout", aV.QuickEdit._editableElementMouseOut); //assign the "private" editableElementMouseOut function to onmouseout event
	aV.Events.add(element, "click", aV.QuickEdit._editableElementClick); //assign the "private" editableElementClick function to onclick event
};

/**
 * This function initializes the aV.QuickEdit system.
 * Downloads the ruleFile if there is one, assigns the necessary property
 * and event handlers to the editable elements.
 * Attached to the window.onload event automatically.
 *
 * @method
 */
aV.QuickEdit.init=function()
{
	//aV.AJAX.loadResource("aV.quickEdit.css", "css", "aVquickEditCSS");
	aV.aParser.assignAttributesFromFile(
		aV.config.QuickEdit['ruleFile'],
		'aVquickEdit',
		aV.QuickEdit._checkElement,
		aV.QuickEdit._setEditableElement
	);

	aV.config.QuickEdit["useInfoBox"]=(aV.config.QuickEdit["useInfoBox"] && aV.Visual.infoBox);
};

aV.Events.add(window, 'load', aV.QuickEdit.init);