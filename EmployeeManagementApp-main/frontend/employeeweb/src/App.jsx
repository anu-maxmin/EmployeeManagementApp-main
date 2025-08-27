import { useState } from 'react'
import './App.css'
import Header from './component/header/Header'
import NoMatch from './component/noMatch/NoMatch'
import { Routes, Route } from 'react-router-dom'
import Dashboard from './component/dashboard/Dashboard'
import PostUser from './component/employee/PostUser'
import UpdateUser from './component/employee/UpdateUser'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Header />
      <Routes>
        <Route path="/" element={<Dashboard/>}></Route>
        <Route path="/employee" element={<PostUser/>}></Route>
        <Route path="/employee/:id" element={<UpdateUser/>}></Route>
        <Route path="*" element={<NoMatch/>}></Route>
      </Routes>
    </>
  )
}

export default App
