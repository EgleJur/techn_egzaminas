import { useEffect, useState } from "react"
import './Menu.css'
import { Link } from "react-router-dom";

export function Menu(props) {

    return (
        <div className="Menu">
            <Link to='/'>Articles</Link>
            &nbsp;|&nbsp;
            <Link to='/create'>Create new article</Link>
            &nbsp;|&nbsp;
            <Link to='/createComment'>Create new comment</Link>
          
        </div>
    )
}