// import logo from '../../assets/talos-transparency.png';
import logo from '../assets/login_temp.png';
import './Login.css';
import { Link, Navigate, useLocation } from 'react-router-dom';
import React from 'react';
import axios from 'axios';
import { urlUsuario } from '../utils';
import clsx from 'clsx';
import AlertHandler from '../AlertHandler';

import { FormControl, InputLabel, InputAdornment, IconButton, Input , Select, MenuItem} from '@material-ui/core';
import Visibility from '@material-ui/icons/Visibility';
import VisibilityOff from '@material-ui/icons/VisibilityOff';
import { useStyles, LoginButton } from './ui-components'

function Login() {
  let location = useLocation();
  const [open, setOpen] = React.useState(false);
  const [showContent, setShowContent] = React.useState(false);
  const [message, setMessage] = React.useState("");
  const [event, setEvent] = React.useState();
  localStorage.setItem('auth', false);

  const [values, setValues] = React.useState({
    password: '',
    usuario: '',
    ciudad: '',
    showPassword: false,
  });

  const handleClose = (event, reason) => {
    if (reason === 'clickaway') {
      return;
    }
    setOpen(false);
  };

  const classes = useStyles();

  const handleChange = (prop) => (event) => {
    setValues({ ...values, [prop]: event.target.value });
  };

  const handleClickShowPassword = () => {
    setValues({ ...values, showPassword: !values.showPassword });
  };

  const handleMouseDownPassword = (event) => {
    event.preventDefault();
  };

  const incomeManagement = (data) => {
    if (data) {
      setShowContent(true);
    } else {
      setMessage(`Wrong password or usuario`)
      setEvent("warning")
      setOpen(true)
    }
  }

  const submitForm = () => {

    // // temporal
    // const user = {
    //   usuario: values.usuario,
    //   password: values.password
    // }
    // if (user.usuario === "admin" && user.password === "admin123") {
    //   localStorage.setItem('auth', true)
    //   setMessage(`Login exitoso`)
    //   setEvent("success")
    //   setOpen(true)
    //   setShowContent(true);
    // } else {
    //   setMessage(`Wrong password or usuario`)
    //   setEvent("warning")
    //   setOpen(true)
    // }

    //la funcion a implementar cuando este bien el backend
    
    const user = {
        usuarioDto : {
          usuario: values.usuario,
          password: values.password
        },
        ciudad : values.ciudad 
    }
    axios.post(urlUsuario, user)
      .then(res => {
        localStorage.setItem('auth', res.data)
        localStorage.setItem('ciudad', user.ciudad)
        incomeManagement(res.data)

      })
      .catch(error => {
        if (error === "Error: Network Error") {
          setMessage(`Communication with the server could not be established`)
          setEvent("error")
          setOpen(true)
        } else {
          setMessage(`Wrong password or usuario`)
          setEvent("warning")
          setOpen(true)
        }

      })

  }

  return (
    <div className='App'>
      <header className='App-header'>
        <div className='login-form'>
          <img src={logo} className='App-logo-margin responsive' alt='logo' />
          <FormControl className={clsx(classes.marginForm, classes.withoutLabel, classes.textField)}>
            <InputLabel htmlFor="standard-adornment-password">usuario</InputLabel>
            <Input
              id="standard-adornment-usuario"
              value={values.usuario}
              autoFocus={true}
              onChange={handleChange('usuario')}
              aria-describedby="standard-usuario-helper-text"
              inputProps={{
                'aria-label': 'usuario',
              }}
            />
          </FormControl>
          <FormControl className={clsx(classes.marginForm, classes.withoutLabel, classes.textField)}>
            <InputLabel htmlFor="standard-adornment-password">Password</InputLabel>
            <Input
              id="standard-adornment-password"
              type={values.showPassword ? 'text' : 'password'}
              value={values.password}
              onChange={handleChange('password')}
              endAdornment={
                <InputAdornment position="end">
                  <IconButton
                    aria-label="toggle password visibility"
                    onClick={handleClickShowPassword}
                    onMouseDown={handleMouseDownPassword}
                  >
                    {values.showPassword ? <Visibility /> : <VisibilityOff />}
                  </IconButton>
                </InputAdornment>
              }
            />
          </FormControl>
          <FormControl className={clsx(classes.marginForm, classes.withoutLabel, classes.textField)}>
            <InputLabel id="demo-simple-select-label" htmlFor="standard-adornment-ciudad">ciudad</InputLabel>
            <Select
              labelId="demo-simple-select-label"
              id="standard-adornment-ciudad"
              value={values.ciudad}
              autoFocus={true}
              label="Ciudad"
              onChange={handleChange('ciudad')}
              aria-describedby="standard-ciudad-helper-text"
              inputProps={{
                'aria-label': 'ciudad',
              }}
            >
              <MenuItem value={"medellin"}>Medellin</MenuItem>
              <MenuItem value={"bogota"}>Bogota</MenuItem>
              <MenuItem value={"cali"}>Cali</MenuItem>
            </Select>

          </FormControl>
          <LoginButton variant="contained" disableRipple onClick={submitForm} className={classes.margin, classes.withoutLabel}>
            Login
          </LoginButton>
          {open
            &&
            <AlertHandler
              description={message}
              event={event}
              action={handleClose}
              show={open}
            />
          }
          {showContent
            &&
            <Navigate to="/home" />
          }
        </div>
      </header>
    </div>
  );
}

export default Login;
