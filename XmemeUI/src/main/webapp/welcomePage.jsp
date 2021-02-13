<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.xmeme.model.Meme"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<div class="memePage">
		<h1>Meme Stream</h1>
		<div>
			<form action="postMeme" method="post" id="memeForm"
				enctype="multipart/form-data">
				<div class="mo">Meme Owner:</div>
				<input class="ownerName" type="text" name="ownerName"
					placeholder="Enter your full name" size="50" required> <br>
				<br>
				<div class="cap">Caption:</div>
				<input class="caption" type="text" name="caption"
					placeholder="Be criative with the caption" size="50" required>
				<br> <br>
				<div class="mu">Meme Url:</div>
				<input class="memeUrl" type="url" name="memeUrl"
					placeholder="Enter your url here" size="36" required>
				<button class="btn" type="submit" form="memeForm" value="Submit"
					size="20">Submit Meme</button>
				<br> <br>
				<hr>
			</form>

		</div>

		<div>
			<%
				List<Meme> memes = new ArrayList<Meme>();
				memes = (ArrayList<Meme>) request.getAttribute("listdata");
				System.out.print(memes);
				if (memes != null && memes.size() > 0) {
					for (int i = 0; i < memes.size(); i++) {
						Meme meme = memes.get(i);
			%>
			<h2 class="outputName"><%=meme.getOwnerName()%></h2>
			<p><%=meme.getCaption()%></p>
			<img class ="img" src="<%=meme.getMemeUrl()%>" width="500" height="400"
				alt="Meme cannot be displayed(Invalid URL)" />
				<br><br>
			<%
				}
				}
			%>
		</div>
	</div>
</body>
</html>
