import React from 'react';
import { configure, shallow } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';
import NavigationItems from './NavigationItems';
import NavigationItem from './NavigationItem/NavigationItem';

configure({ adapter: new Adapter() });

describe('<NavigationItems />', () => {
  let wrapper;

  beforeEach(() => {
    wrapper = wrapper.find(NavigationItem)
  })

  it('should render two <NavitationItem/> elements if not authenticated', () => {
    const wrapper = shallow(<NavigationItems />);
    expect(wrapper).toHaveLength(2);
  });

  it('should render three <NavitationItem/> elements if authenticated', () => {
    wrapper.setProps({ isAuthenticated: true });
    expect(wrapper).toHaveLength(3);
  });

  it('should render three <NavitationItem/> elements if authenticated1', () => {
    wrapper.setProps({ isAuthenticated: true });
    expect(wrapper.contains(<NavigationItem link="/logout">Logout</NavigationItem>)).toEqual(true);
  });
});