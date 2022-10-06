<%-- 
    Document   : GameDetails
    Created on : Oct 6, 2022, 9:51:54 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/game-details.css">
        <link rel="stylesheet" href="css/fonts/themify-icons/themify-icons.css">
    </head>
    <body>
        <div id="container">
            <div id="header">

            </div>
            <!-- <div id="search-bar">
    
            </div> -->
            <div id="content">
                <div id="game-info">
                    <div class="heading">Cuphead</div>
                    <div id="selected-game">
                        <!--lay tu 1 list anh-->
                        <div id="game-picture">
                            <div id="big-pic">
                                <img src="https://cdn.akamai.steamstatic.com/steam/apps/268910/ss_380296effbf1073bbedfd480e50cf246eb542b66.600x338.jpg?t=1661955091" alt="">
                            </div>
                            <div id="small-pic">
                                <div class="pic">
                                    <img src="https://cdn.akamai.steamstatic.com/steam/apps/268910/ss_48477e4a865827aa0be6a44f00944d8d2a3e5eb9.1920x1080.jpg?t=1661955091" alt="">
                                </div>
                                <div class="pic">
                                    <img src="https://cdn.akamai.steamstatic.com/steam/apps/268910/ss_483fb089be0093beeef03525276803a9ca4f66a1.600x338.jpg?t=1661955091" alt="">
                                </div>
                                <div class="pic">
                                    <img src="https://cdn.akamai.steamstatic.com/steam/apps/268910/ss_aefad3850c3bc04000cbe0d620bea6807e0a0331.600x338.jpg?t=1661955091" alt="">
                                </div>
                                <div class="pic">
                                    <img src="https://cdn.akamai.steamstatic.com/steam/apps/268910/ss_1bfaa0d236aa99cdc31234aa7aad314898e3d10e.600x338.jpg?t=1661955091" alt="">
                                </div>
                                <div class="pic">
                                    <img src="https://cdn.akamai.steamstatic.com/steam/apps/268910/ss_874f2d27a9120ee60cbce0c7bd4085525fd09b26.600x338.jpg?t=1661955091" alt="">
                                </div>
                            </div>

                        </div>
                        <div id="game-details">
                            <div id="game-poster">
                                <!--lay tu game-poster-->
                                <img src="https://cdn.akamai.steamstatic.com/steam/apps/268910/header.jpg?t=1661955091" alt="">
                            </div>
                            <div id="game-detail-info">
                                <!--lay tu game description(ko dc dai qua, max la nhu cai vi du nay)-->
                                <p>Cuphead is a classic run and gun action game heavily focused on boss battles. Inspired by cartoons of the 1930s, the visuals and audio are painstakingly created with the same techniques of the era, i.e. traditional hand drawn cel animation, watercolor backgrounds, and original jazz recordings.</p>
                                 <!--lay tu game published by-->
                                <p>Published by: Studio MDHR Entertainment Inc.</p>
                                <!--lay tu game dev-->
                                <p>Developer: Studio MDHR Entertainment Inc.</p>

                            </div>
                        </div>
                        <div class="clear"></div>
                    </div>

                    <div id="action">
                        <div id="rating">
                            <p>Rating: </p>
                            <span>
                                <icon class="ti-star" style="color: rgb(245, 5, 5);"></icon>
                                <icon class="ti-star" style="color: rgb(245, 5, 5);"></icon>
                                <icon class="ti-star" style="color: rgb(245, 5, 5);"></icon>
                                <icon class="ti-star"></icon>
                                <icon class="ti-star"></icon>
                            </span>
                        </div>
                        <div id="btn">
                            <button id="buy" style="background-color: rgb(92, 92, 198);">BUY</button>

                            <div class="price" style="background-color: green;">
                                <div class="first-price">400$</div>
                                <div class="after-price">200$</div>
                            </div>
                            <div id="discount" style="background-color: purple;">-50%</div>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div id="user-comment">
                        <div class="heading-content">Comment</div>
                    </div>
                </div>
                <div id="more-game">
                    <div class="heading">
                        <div class="heading-content">More like this</div>
                        <div id="see-all-link" style="font-size: 15px">
                            <a href="" >See all</a>
                            <icon class="ti-arrow-right"></icon>
                        </div>
                    </div>
                    <!--lay tu 1 list gom 4 game cung category voi game nay-->
                    <div id="games">
                        <div class="game">
                            <div class="overview-pic">
                                <img src="https://cdn.akamai.steamstatic.com/steam/apps/233860/header.jpg?t=1664817530" alt="">
                            </div>
                            <div class="overview-info">
                                <div class="game-name">Kenshi</div>
                                <div class="price">200$</div>
                            </div>
                        </div>
                        <div class="game">
                            <div class="overview-pic">
                                <img src="https://cdn.akamai.steamstatic.com/steam/apps/233860/header.jpg?t=1664817530" alt="">
                            </div>
                            <div class="overview-info">
                                <div class="game-name">Kenshi</div>
                                <div class="price">200$</div>
                            </div>
                        </div>
                        <div class="game">
                            <div class="overview-pic">
                                <img src="https://cdn.akamai.steamstatic.com/steam/apps/233860/header.jpg?t=1664817530" alt="">
                            </div>
                            <div class="overview-info">
                                <div class="game-name">Kenshi</div>
                                <div class="price">200$</div>
                            </div>
                        </div>
                        <div class="game">
                            <div class="overview-pic">
                                <img src="https://cdn.akamai.steamstatic.com/steam/apps/233860/header.jpg?t=1664817530" alt="">
                            </div>
                            <div class="overview-info">
                                <div class="game-name">Kenshi</div>
                                <div class="price">200$</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </body>
</html>
