import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";



export function ViewArticle() {
    const [article, setArticle] = useState({});
    const params = useParams();

useEffect(()=>{
    fetch('api/v1/articles/' + params.id)
    .then((response)=> response.json())
    .then(setArticle)
}, [params.id]);

    return(<div>
           
           <div><b>id</b></div>
            <div>{article.id}</div> 

            <div><b>Name</b></div>
            <div>{article.name}</div>
         

            <div><b>Description</b></div>
            <div>{article.description}</div>
            
            <div><b>Data</b></div>
            <div>{article.createdDate}</div>

           
        </div>);


}
