<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang = "en">

<head>

<link rel="icon"          href="http://algs4.cs.princeton.edu/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="http://algs4.cs.princeton.edu/favicon.ico" type="image/x-icon">
<link rel="stylesheet"    href="http://algs4.cs.princeton.edu/java.css" type="text/css">

<title>ClosestPair.java</title>

<meta HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=iso-8859-1">
<meta NAME="AUTHOR" CONTENT="Robert Sedgewick and Kevin Wayne">
<meta NAME="DESCRIPTION" CONTENT="ClosestPair code in Java">
<meta NAME="TITLE" CONTENT="ClosestPair code in Java">
<meta NAME="KEYWORDS" CONTENT="ClosestPair,java,programming,computer science,algorithm,data structure,program,code">
<meta NAME="ROBOTS" CONTENT="INDEX,FOLLOW">

</head>


<body>
<center><h1>ClosestPair.java</h1></center><p><br>

Below is the syntax highlighted version of <a href = "ClosestPair.java">ClosestPair.java</a>
from <a href = "http://algs4.cs.princeton.edu/25applications">&#167;2.5 Sorting Applications</a>.
<p><br>

<!-- Generator: GNU source-highlight 2.5
by Lorenzo Bettini
http://www.lorenzobettini.it
http://www.gnu.org/software/src-highlite -->
<pre><tt><span class="comment">/*************************************************************************</span>
<span class="comment"> *  Compilation:  javac ClosestPair.java</span>
<span class="comment"> *  Execution:    java ClosestPair &lt; input.txt</span>
<span class="comment"> *  Dependencies: Point2D.java</span>
<span class="comment"> *  </span>
<span class="comment"> *  Given N points in the plane, find the closest pair in N log N time.</span>
<span class="comment"> *</span>
<span class="comment"> *  Note: could speed it up by comparing square of Euclidean distances</span>
<span class="comment"> *  instead of Euclidean distances.</span>
<span class="comment"> *</span>
<span class="comment"> *************************************************************************/</span>

<span class="preproc">import</span><span class="normal"> java</span><span class="symbol">.</span><span class="normal">util</span><span class="symbol">.</span><span class="normal">Arrays</span><span class="symbol">;</span>

<span class="keyword">public</span><span class="normal"> </span><span class="keyword">class</span><span class="normal"> ClosestPair </span><span class="cbracket">{</span>

<span class="normal">    </span><span class="comment">// closest pair of points and their Euclidean distance</span>
<span class="normal">    </span><span class="keyword">private</span><span class="normal"> Point2D best1</span><span class="symbol">,</span><span class="normal"> best2</span><span class="symbol">;</span>
<span class="normal">    </span><span class="keyword">private</span><span class="normal"> </span><span class="type">double</span><span class="normal"> bestDistance </span><span class="symbol">=</span><span class="normal"> Double</span><span class="symbol">.</span><span class="normal">POSITIVE_INFINITY</span><span class="symbol">;</span>

<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="function">ClosestPair</span><span class="symbol">(</span><span class="normal">Point2D</span><span class="symbol">[]</span><span class="normal"> points</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="type">int</span><span class="normal"> N </span><span class="symbol">=</span><span class="normal"> points</span><span class="symbol">.</span><span class="normal">length</span><span class="symbol">;</span>
<span class="normal">        </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">N </span><span class="symbol">&lt;=</span><span class="normal"> </span><span class="number">1</span><span class="symbol">)</span><span class="normal"> </span><span class="keyword">return</span><span class="symbol">;</span>

<span class="normal">        </span><span class="comment">// sort by x-coordinate (breaking ties by y-coordinate)</span>
<span class="normal">        Point2D</span><span class="symbol">[]</span><span class="normal"> pointsByX </span><span class="symbol">=</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> Point2D</span><span class="symbol">[</span><span class="normal">N</span><span class="symbol">];</span>
<span class="normal">        </span><span class="keyword">for</span><span class="normal"> </span><span class="symbol">(</span><span class="type">int</span><span class="normal"> i </span><span class="symbol">=</span><span class="normal"> </span><span class="number">0</span><span class="symbol">;</span><span class="normal"> i </span><span class="symbol">&lt;</span><span class="normal"> N</span><span class="symbol">;</span><span class="normal"> i</span><span class="symbol">++)</span><span class="normal"> pointsByX</span><span class="symbol">[</span><span class="normal">i</span><span class="symbol">]</span><span class="normal"> </span><span class="symbol">=</span><span class="normal"> points</span><span class="symbol">[</span><span class="normal">i</span><span class="symbol">];</span>
<span class="normal">        Arrays</span><span class="symbol">.</span><span class="function">sort</span><span class="symbol">(</span><span class="normal">pointsByX</span><span class="symbol">,</span><span class="normal"> Point2D</span><span class="symbol">.</span><span class="normal">X_ORDER</span><span class="symbol">);</span>

<span class="normal">        </span><span class="comment">// check for coincident points</span>
<span class="normal">        </span><span class="keyword">for</span><span class="normal"> </span><span class="symbol">(</span><span class="type">int</span><span class="normal"> i </span><span class="symbol">=</span><span class="normal"> </span><span class="number">0</span><span class="symbol">;</span><span class="normal"> i </span><span class="symbol">&lt;</span><span class="normal"> N</span><span class="symbol">-</span><span class="number">1</span><span class="symbol">;</span><span class="normal"> i</span><span class="symbol">++)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">            </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">pointsByX</span><span class="symbol">[</span><span class="normal">i</span><span class="symbol">].</span><span class="function">equals</span><span class="symbol">(</span><span class="normal">pointsByX</span><span class="symbol">[</span><span class="normal">i</span><span class="symbol">+</span><span class="number">1</span><span class="symbol">]))</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">                bestDistance </span><span class="symbol">=</span><span class="normal"> </span><span class="number">0.0</span><span class="symbol">;</span>
<span class="normal">                best1 </span><span class="symbol">=</span><span class="normal"> pointsByX</span><span class="symbol">[</span><span class="normal">i</span><span class="symbol">];</span>
<span class="normal">                best2 </span><span class="symbol">=</span><span class="normal"> pointsByX</span><span class="symbol">[</span><span class="normal">i</span><span class="symbol">+</span><span class="number">1</span><span class="symbol">];</span>
<span class="normal">                </span><span class="keyword">return</span><span class="symbol">;</span>
<span class="normal">            </span><span class="cbracket">}</span>
<span class="normal">        </span><span class="cbracket">}</span>

<span class="normal">        </span><span class="comment">// sort by y-coordinate (but not yet sorted) </span>
<span class="normal">        Point2D</span><span class="symbol">[]</span><span class="normal"> pointsByY </span><span class="symbol">=</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> Point2D</span><span class="symbol">[</span><span class="normal">N</span><span class="symbol">];</span>
<span class="normal">        </span><span class="keyword">for</span><span class="normal"> </span><span class="symbol">(</span><span class="type">int</span><span class="normal"> i </span><span class="symbol">=</span><span class="normal"> </span><span class="number">0</span><span class="symbol">;</span><span class="normal"> i </span><span class="symbol">&lt;</span><span class="normal"> N</span><span class="symbol">;</span><span class="normal"> i</span><span class="symbol">++)</span><span class="normal"> pointsByY</span><span class="symbol">[</span><span class="normal">i</span><span class="symbol">]</span><span class="normal"> </span><span class="symbol">=</span><span class="normal"> pointsByX</span><span class="symbol">[</span><span class="normal">i</span><span class="symbol">];</span>

<span class="normal">        </span><span class="comment">// auxiliary array</span>
<span class="normal">        Point2D</span><span class="symbol">[]</span><span class="normal"> aux </span><span class="symbol">=</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> Point2D</span><span class="symbol">[</span><span class="normal">N</span><span class="symbol">];</span>

<span class="normal">        </span><span class="function">closest</span><span class="symbol">(</span><span class="normal">pointsByX</span><span class="symbol">,</span><span class="normal"> pointsByY</span><span class="symbol">,</span><span class="normal"> aux</span><span class="symbol">,</span><span class="normal"> </span><span class="number">0</span><span class="symbol">,</span><span class="normal"> N</span><span class="symbol">-</span><span class="number">1</span><span class="symbol">);</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="comment">// find closest pair of points in pointsByX[lo..hi]</span>
<span class="normal">    </span><span class="comment">// precondition:  pointsByX[lo..hi] and pointsByY[lo..hi] are the same sequence of points</span>
<span class="normal">    </span><span class="comment">// precondition:  pointsByX[lo..hi] sorted by x-coordinate</span>
<span class="normal">    </span><span class="comment">// postcondition: pointsByY[lo..hi] sorted by y-coordinate</span>
<span class="normal">    </span><span class="keyword">private</span><span class="normal"> </span><span class="type">double</span><span class="normal"> </span><span class="function">closest</span><span class="symbol">(</span><span class="normal">Point2D</span><span class="symbol">[]</span><span class="normal"> pointsByX</span><span class="symbol">,</span><span class="normal"> Point2D</span><span class="symbol">[]</span><span class="normal"> pointsByY</span><span class="symbol">,</span><span class="normal"> Point2D</span><span class="symbol">[]</span><span class="normal"> aux</span><span class="symbol">,</span><span class="normal"> </span><span class="type">int</span><span class="normal"> lo</span><span class="symbol">,</span><span class="normal"> </span><span class="type">int</span><span class="normal"> hi</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">hi </span><span class="symbol">&lt;=</span><span class="normal"> lo</span><span class="symbol">)</span><span class="normal"> </span><span class="keyword">return</span><span class="normal"> Double</span><span class="symbol">.</span><span class="normal">POSITIVE_INFINITY</span><span class="symbol">;</span>

<span class="normal">        </span><span class="type">int</span><span class="normal"> mid </span><span class="symbol">=</span><span class="normal"> lo </span><span class="symbol">+</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">hi </span><span class="symbol">-</span><span class="normal"> lo</span><span class="symbol">)</span><span class="normal"> </span><span class="symbol">/</span><span class="normal"> </span><span class="number">2</span><span class="symbol">;</span>
<span class="normal">        Point2D median </span><span class="symbol">=</span><span class="normal"> pointsByX</span><span class="symbol">[</span><span class="normal">mid</span><span class="symbol">];</span>

<span class="normal">        </span><span class="comment">// compute closest pair with both endpoints in left subarray or both in right subarray</span>
<span class="normal">        </span><span class="type">double</span><span class="normal"> delta1 </span><span class="symbol">=</span><span class="normal"> </span><span class="function">closest</span><span class="symbol">(</span><span class="normal">pointsByX</span><span class="symbol">,</span><span class="normal"> pointsByY</span><span class="symbol">,</span><span class="normal"> aux</span><span class="symbol">,</span><span class="normal"> lo</span><span class="symbol">,</span><span class="normal"> mid</span><span class="symbol">);</span>
<span class="normal">        </span><span class="type">double</span><span class="normal"> delta2 </span><span class="symbol">=</span><span class="normal"> </span><span class="function">closest</span><span class="symbol">(</span><span class="normal">pointsByX</span><span class="symbol">,</span><span class="normal"> pointsByY</span><span class="symbol">,</span><span class="normal"> aux</span><span class="symbol">,</span><span class="normal"> mid</span><span class="symbol">+</span><span class="number">1</span><span class="symbol">,</span><span class="normal"> hi</span><span class="symbol">);</span>
<span class="normal">        </span><span class="type">double</span><span class="normal"> delta </span><span class="symbol">=</span><span class="normal"> Math</span><span class="symbol">.</span><span class="function">min</span><span class="symbol">(</span><span class="normal">delta1</span><span class="symbol">,</span><span class="normal"> delta2</span><span class="symbol">);</span>

<span class="normal">        </span><span class="comment">// merge back so that pointsByY[lo..hi] are sorted by y-coordinate</span>
<span class="normal">        Merge</span><span class="symbol">.</span><span class="function">merge</span><span class="symbol">(</span><span class="normal">pointsByY</span><span class="symbol">,</span><span class="normal"> aux</span><span class="symbol">,</span><span class="normal"> lo</span><span class="symbol">,</span><span class="normal"> mid</span><span class="symbol">,</span><span class="normal"> hi</span><span class="symbol">);</span>

<span class="normal">        </span><span class="comment">// aux[0..M-1] = sequence of points closer than delta, sorted by y-coordinate</span>
<span class="normal">        </span><span class="type">int</span><span class="normal"> M </span><span class="symbol">=</span><span class="normal"> </span><span class="number">0</span><span class="symbol">;</span>
<span class="normal">        </span><span class="keyword">for</span><span class="normal"> </span><span class="symbol">(</span><span class="type">int</span><span class="normal"> i </span><span class="symbol">=</span><span class="normal"> lo</span><span class="symbol">;</span><span class="normal"> i </span><span class="symbol">&lt;=</span><span class="normal"> hi</span><span class="symbol">;</span><span class="normal"> i</span><span class="symbol">++)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">            </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">Math</span><span class="symbol">.</span><span class="function">abs</span><span class="symbol">(</span><span class="normal">pointsByY</span><span class="symbol">[</span><span class="normal">i</span><span class="symbol">].</span><span class="function">x</span><span class="symbol">()</span><span class="normal"> </span><span class="symbol">-</span><span class="normal"> median</span><span class="symbol">.</span><span class="function">x</span><span class="symbol">())</span><span class="normal"> </span><span class="symbol">&lt;</span><span class="normal"> delta</span><span class="symbol">)</span>
<span class="normal">                aux</span><span class="symbol">[</span><span class="normal">M</span><span class="symbol">++]</span><span class="normal"> </span><span class="symbol">=</span><span class="normal"> pointsByY</span><span class="symbol">[</span><span class="normal">i</span><span class="symbol">];</span>
<span class="normal">        </span><span class="cbracket">}</span>

<span class="normal">        </span><span class="comment">// compare each point to its neighbors with y-coordinate closer than delta</span>
<span class="normal">        </span><span class="keyword">for</span><span class="normal"> </span><span class="symbol">(</span><span class="type">int</span><span class="normal"> i </span><span class="symbol">=</span><span class="normal"> </span><span class="number">0</span><span class="symbol">;</span><span class="normal"> i </span><span class="symbol">&lt;</span><span class="normal"> M</span><span class="symbol">;</span><span class="normal"> i</span><span class="symbol">++)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">            </span><span class="comment">// a geometric packing argument shows that this loop iterates at most 7 times</span>
<span class="normal">            </span><span class="keyword">for</span><span class="normal"> </span><span class="symbol">(</span><span class="type">int</span><span class="normal"> j </span><span class="symbol">=</span><span class="normal"> i</span><span class="symbol">+</span><span class="number">1</span><span class="symbol">;</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">j </span><span class="symbol">&lt;</span><span class="normal"> M</span><span class="symbol">)</span><span class="normal"> </span><span class="symbol">&amp;&amp;</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">aux</span><span class="symbol">[</span><span class="normal">j</span><span class="symbol">].</span><span class="function">y</span><span class="symbol">()</span><span class="normal"> </span><span class="symbol">-</span><span class="normal"> aux</span><span class="symbol">[</span><span class="normal">i</span><span class="symbol">].</span><span class="function">y</span><span class="symbol">()</span><span class="normal"> </span><span class="symbol">&lt;</span><span class="normal"> delta</span><span class="symbol">);</span><span class="normal"> j</span><span class="symbol">++)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">                </span><span class="type">double</span><span class="normal"> distance </span><span class="symbol">=</span><span class="normal"> aux</span><span class="symbol">[</span><span class="normal">i</span><span class="symbol">].</span><span class="function">distanceTo</span><span class="symbol">(</span><span class="normal">aux</span><span class="symbol">[</span><span class="normal">j</span><span class="symbol">]);</span>
<span class="normal">                </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">distance </span><span class="symbol">&lt;</span><span class="normal"> delta</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">                    delta </span><span class="symbol">=</span><span class="normal"> distance</span><span class="symbol">;</span>
<span class="normal">                    </span><span class="keyword">if</span><span class="normal"> </span><span class="symbol">(</span><span class="normal">distance </span><span class="symbol">&lt;</span><span class="normal"> bestDistance</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">                        bestDistance </span><span class="symbol">=</span><span class="normal"> delta</span><span class="symbol">;</span>
<span class="normal">                        best1 </span><span class="symbol">=</span><span class="normal"> aux</span><span class="symbol">[</span><span class="normal">i</span><span class="symbol">];</span>
<span class="normal">                        best2 </span><span class="symbol">=</span><span class="normal"> aux</span><span class="symbol">[</span><span class="normal">j</span><span class="symbol">];</span>
<span class="normal">                        </span><span class="comment">// StdOut.println("better distance = " + delta + " from " + best1 + " to " + best2);</span>
<span class="normal">                    </span><span class="cbracket">}</span>
<span class="normal">                </span><span class="cbracket">}</span>
<span class="normal">            </span><span class="cbracket">}</span>
<span class="normal">        </span><span class="cbracket">}</span>
<span class="normal">        </span><span class="keyword">return</span><span class="normal"> delta</span><span class="symbol">;</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="keyword">public</span><span class="normal"> Point2D </span><span class="function">either</span><span class="symbol">()</span><span class="normal"> </span><span class="cbracket">{</span><span class="normal"> </span><span class="keyword">return</span><span class="normal"> best1</span><span class="symbol">;</span><span class="normal"> </span><span class="cbracket">}</span>
<span class="normal">    </span><span class="keyword">public</span><span class="normal"> Point2D </span><span class="function">other</span><span class="symbol">()</span><span class="normal">  </span><span class="cbracket">{</span><span class="normal"> </span><span class="keyword">return</span><span class="normal"> best2</span><span class="symbol">;</span><span class="normal"> </span><span class="cbracket">}</span>

<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="type">double</span><span class="normal"> </span><span class="function">distance</span><span class="symbol">()</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="keyword">return</span><span class="normal"> bestDistance</span><span class="symbol">;</span>
<span class="normal">    </span><span class="cbracket">}</span>


<span class="normal">    </span><span class="keyword">public</span><span class="normal"> </span><span class="keyword">static</span><span class="normal"> </span><span class="type">void</span><span class="normal"> </span><span class="function">main</span><span class="symbol">(</span><span class="normal">String</span><span class="symbol">[]</span><span class="normal"> args</span><span class="symbol">)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">        </span><span class="type">int</span><span class="normal"> N </span><span class="symbol">=</span><span class="normal"> StdIn</span><span class="symbol">.</span><span class="function">readInt</span><span class="symbol">();</span>
<span class="normal">        Point2D</span><span class="symbol">[]</span><span class="normal"> points </span><span class="symbol">=</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> Point2D</span><span class="symbol">[</span><span class="normal">N</span><span class="symbol">];</span>
<span class="normal">        </span><span class="keyword">for</span><span class="normal"> </span><span class="symbol">(</span><span class="type">int</span><span class="normal"> i </span><span class="symbol">=</span><span class="normal"> </span><span class="number">0</span><span class="symbol">;</span><span class="normal"> i </span><span class="symbol">&lt;</span><span class="normal"> N</span><span class="symbol">;</span><span class="normal"> i</span><span class="symbol">++)</span><span class="normal"> </span><span class="cbracket">{</span>
<span class="normal">            </span><span class="type">double</span><span class="normal"> x </span><span class="symbol">=</span><span class="normal"> StdIn</span><span class="symbol">.</span><span class="function">readDouble</span><span class="symbol">();</span>
<span class="normal">            </span><span class="type">double</span><span class="normal"> y </span><span class="symbol">=</span><span class="normal"> StdIn</span><span class="symbol">.</span><span class="function">readDouble</span><span class="symbol">();</span>
<span class="normal">            points</span><span class="symbol">[</span><span class="normal">i</span><span class="symbol">]</span><span class="normal"> </span><span class="symbol">=</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> </span><span class="function">Point2D</span><span class="symbol">(</span><span class="normal">x</span><span class="symbol">,</span><span class="normal"> y</span><span class="symbol">);</span>
<span class="normal">        </span><span class="cbracket">}</span>
<span class="normal">        ClosestPair closest </span><span class="symbol">=</span><span class="normal"> </span><span class="keyword">new</span><span class="normal"> </span><span class="function">ClosestPair</span><span class="symbol">(</span><span class="normal">points</span><span class="symbol">);</span>
<span class="normal">        StdOut</span><span class="symbol">.</span><span class="function">println</span><span class="symbol">(</span><span class="normal">closest</span><span class="symbol">.</span><span class="function">distance</span><span class="symbol">()</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> </span><span class="string">" from "</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> closest</span><span class="symbol">.</span><span class="function">either</span><span class="symbol">()</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> </span><span class="string">" to "</span><span class="normal"> </span><span class="symbol">+</span><span class="normal"> closest</span><span class="symbol">.</span><span class="function">other</span><span class="symbol">());</span>
<span class="normal">    </span><span class="cbracket">}</span>

<span class="cbracket">}</span>
</tt></pre>

<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-10811519-2");
pageTracker._trackPageview();
} catch(err) {}</script>

</body>

<p><br><address><small>
Copyright &copy; 2002&ndash;2010, Robert Sedgewick and Kevin Wayne.
<br>Last updated: Wed Aug  3 08:59:59 EDT 2011.
</small></address>

</html>
