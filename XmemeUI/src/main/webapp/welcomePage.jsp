<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.xmeme.model.Meme"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
	<div class="memePage">
		<h1>Meme Stream</h1>
		<div>
			<form action="postMeme" method="post" id="memeForm"
				enctype="multipart/form-data">
				<div>Meme Owner:</div>
				<input type="text" name="ownerName"
					placeholder="Enter your full name" size="30" height="30" required> <br> <br>
				<div>Caption:</div>
				<input type="text" name="caption"
					placeholder="Be criative with the caption" size="30" required> <br> <br>
				<div>Meme Url:</div>
				<input type="url" name="memeUrl" placeholder="Enter your Url Here" size="30" required>
				<br> <br>
			</form>
			<button type="submit" form="memeForm" value="Submit">Submit</button>
		</div>
		
		<div >
			<%
				List<Meme> memes = new ArrayList<Meme>();
				memes = (ArrayList<Meme>) request.getAttribute("listdata");
				System.out.print(memes);
				if (memes != null && memes.size() > 0) {
					for (int i = 0; i < memes.size(); i++) {
						Meme meme = memes.get(i);
			%>
			<p><%=meme.getOwnerName()%></p>
			<p><%=meme.getCaption()%></p>
			<img src="<%=meme.getMemeUrl()%>" width="500" height="400"
				alt="Meme cannot be displayed(Invalid URL)" />
			<%
				}
				}
			%>
		</div>
	</div>
</body>
</html>
