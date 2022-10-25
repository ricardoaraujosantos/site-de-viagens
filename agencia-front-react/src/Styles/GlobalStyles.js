import { createGlobalStyle } from "styled-components";

const GlobalStyles = createGlobalStyle`

*{
    padding: 0;
    margin: 0;
    font-size: 18px;
    box-sizing: border-box;
}

a{
    text-decoration: none;
    color: black;
    &:hover{
        filter: opacity(0.9);
        color:  black;
       opacity: 0.8;
    }
}

@media screen and (max-width: 425px) {
    
    .bg-nav-container{
        height: 380px;
    }

    .carousel-aside{
        max-width: 100%;    
        margin: 20px 0;
    }

    .ajust-capture-sm {
        width: 87px;
        text-align: left;
        padding: 2px 0;
    }

    .ajust-nav-sm{
        flex-wrap: wrap;
        justify-content: center;
        width: 100%;  
    }

    .ajust-nav-sm li{
        width: 300px;  
    }

    .sm-footer-row{
       display: flex;
       flex-direction: column;
    }
    
    .sm-footer-row .sm-footer-col {
      width: 300px;
    }

}

`
export default GlobalStyles;