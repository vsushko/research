import React, { Component, Suspense } from 'react';
import Posts from './Posts/Posts';
import NewPost from './NewPost/NewPost'
import { Route, NavLink, Switch, Redirect } from 'react-router-dom';
import asyncComponent from '../../hoc/asyncComponent';

import './Blog.css';

// const AsyncNewPost = asyncComponent(() => {
//   // special syntax for the dynamic import 
//   return import('./NewPost/NewPost');
// });

// const NewPost = React.lazy(() => import('./NewPost/NewPost'));

class Blog extends Component {

  state = {
    auth: true
  }

  render() {
    return (
      <div className="Blog">
        <header>
          <nav>
            <ul>
              <li><NavLink to="/posts/" exact activeClassName="active" activeStyle={{
                color: '#fa923f',
                textDecoration: 'underline'
              }}>Posts</NavLink></li>
              <li><NavLink to={{
                pathname: '/new-post',
                hash: '#submit',
                search: '?quick-submit=true'
              }}>New Post</NavLink></li>
            </ul>
          </nav>
        </header>
        {
          // <Route path="/" exact render={() => <h1>Home</h1>} />
          // <Route path="/" render={() => <h1>Home 2</h1>} />
        }
        <Switch>
          {
            this.state.auth ? <Route path='/new-post' component={NewPost} /> : null
            // this.state.auth ? <Route path='/new-post' component={AsyncNewPost} /> : null
            // this.state.auth ? <Route path='/new-post' render={() => <Suspense fallback={<div>Loading...</div>}><NewPost /></Suspense>} /> : null
          }
          <Route path='/posts' component={Posts} />
          <Route render={() => <h1>Not found</h1>} />
          {/*<Redirect from="/" to="/posts" />*/}
          {/* <Route path="/" component={Posts} />*/}
        </Switch>
      </div>
    );
  }
}

export default Blog;