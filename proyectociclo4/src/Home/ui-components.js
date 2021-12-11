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
}));

export const MenuButtons = withStyles({
  root: {
    boxShadow: 'none',
    textTransform: 'none',
    fontSize: 16,
    padding: '0.375rem 0.75rem',
    border: '0.063rem solid',
    borderRadius: '2rem',
    lineHeight: 1.25,
    backgroundColor: '#000000',
    color: '#ffffff',
    display: 'block',
    alignItems: 'center',
    margin: '1.5rem auto',
    width: '9rem',
    height: '2.5rem',
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

