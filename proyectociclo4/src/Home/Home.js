import './Home.css';
import { Navigate } from 'react-router-dom';
import React, { useEffect } from 'react';
import { useStyles, MenuButtons } from './ui-components'
import AlertHandler from '../AlertHandler';
import { Button } from '@material-ui/core';

function Home() {
  const classes = useStyles();
  const [open, setOpen] = React.useState(false);
  const [url, setUrl] = React.useState(false);
  const [refresh, setRefresh] = React.useState(false);

  // if (refresh === false) {
  //   setRefresh(true)
  //   window.location.href = window.location.href
  //   console.log("here", refresh)
  // }
  const getImage = async () => {

    try {
      const apiKey = 'hJf328oXUtMKjnMSCMMcC6vJkAbJhv2T';
      const resp = await fetch(`https://api.giphy.com/v1/gifs/random?api_key=${apiKey}`)
      const { data } = await resp.json();

      const { url } = data.images.original;
      setUrl(url);
      // const img = document.createElement('img');
      // img.src = url;
      // document.body.append(img);
      setOpen(true);

    } catch (error) {
      //manejo del error
      console.error(error)
      setOpen(false);
    }

  }
  const handdleGift = () => {
    getImage()
  }

  return (
    <>

      <div>
        <MenuButtons variant="contained" onClick={handdleGift} className={classes.margin, classes.withoutLabel}>
          Refresh Gift
        </MenuButtons>
        {open
          &&
          <div className='gift-container'>
            <img src={url} className='App-logo-margin responsive' alt='logo' />
          </div>
        }
        {/* <MenuButtons variant="contained" disableRipple onClick={comeBackEvent} className={classes.margin, classes.withoutLabel}>
          Logout
        </MenuButtons> */}
      </div>

    </>
  )
}

export default Home;
