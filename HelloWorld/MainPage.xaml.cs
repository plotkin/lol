using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Shapes;
using Microsoft.Phone.Controls;


namespace HelloWorld
{
    public partial class MainPage : PhoneApplicationPage
    {
        // Конструктор
        public MainPage()
        {
            InitializeComponent();
            name.Text = Orientation.ToString();
        }



        private void ContentPanel_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {
            name.Text = string.Format("Windows Phone 7 - its really comfortable platform\n", name.Width);
        }

        private void PhoneApplicationPage_OrientationChanged(object sender, OrientationChangedEventArgs e)
        {
            name.Text = e.Orientation.ToString();
            base.OnOrientationChanged(e);
        }
    }
}