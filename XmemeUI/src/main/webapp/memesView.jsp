<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="com.xmeme.model.Meme" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<body>
	<h1>Meme Stream</h1>
	
	<div>
	<%List<Meme> memes = new ArrayList<Meme>();
	memes = (ArrayList<Meme>)request.getAttribute("listdata");
	System.out.print(memes);
	if(memes!=null&&memes.size()>0){
	for(int i=0; i<memes.size();i++){
		Meme meme = memes.get(i);%>
		<p><%=meme.getOwnerName() %></p>
		<p><%=meme.getCaption() %></p>
		<img src = "<%=meme.getMemeUrl()%>" width="500" height="400" alt = "Meme cannot be displayed(Invalid URL)"/>
		<%}}%>


	
	</div>
</body>
</html>
