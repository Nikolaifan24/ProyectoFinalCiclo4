import { makeStyles, withStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';

export const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
    flexWrap: 'wrap',
  },
  marginForm: {
    marginForm: theme.spacing(1),
  },
  withoutLabel: {
    margin: '0 0 1rem 0',
    padding: 'inherit',
  },
  textField: {
    width: '25ch',
    '@media (max-width: 576px)': {
      width: '15ch',
    },
    '@media (min-width: 1000px)': {
      width: '35ch',
    },
    '@media (min-width: 1500px)': {
      width: '45ch',
    },
    '@media (min-width: 1900px)': {
      width: '55ch',
    },
  },
}));

export const LoginButton = withStyles({
  root: {
    boxShadow: 'none',
    textTransform: 'none',
    fontSize: 16,
    padding: '6px 12px',
    border: '1px solid',
    borderRadius: '1rem',
    lineHeight: 1.25,
    backgroundColor: '#000000',
    color: '#ffffff',
    display: 'block',
    alignItems: 'center',
    margin: '2rem auto',
    width: '8rem',
    height: '2rem',
    '&:hover': {
      backgroundColor: '#f35754',
      color: '#ffffff',
      boxShadow: 'none',
      transition: '250ms background ease-in',
    },
    '&:active': {
      boxShadow: 'none',
      backgroundColor: '#f35754',
      fontWeight: 600,
    },
  },
})(Button);

