# Implementing asciidoctor-interdoc-reftext

This project is a simple acsiidoc project having 2 adoc's [demo.adoc](demo.adoc)
and [demoReference.adoc](demoReference.adoc).

The idea is to define adocs with `xref:demo.adoc[]` and when it is is generated it should display the title of the adoc
in the link.
As in `xref:demo.adoc[]` should become `xref:demo.adoc[This is a demo]`.

And it all works. When you run `.\gradlew.bat asciidoctor` it produces an
HTML [demoReference.html](build/docs/asciidoc/demoReference.html) with the correct text.

## Problem

There seems to be a problem with Ruby.

In the [build.gradle.kts](build.gradle.kts) under `dependencies` and `asciidoctorj` the JRuby version is set and ensured
that it only uses one version.

When the JRuby version is set to '9.3.x' it works. As per my understanding this will work with Ruby versions `2.6.x`.
As soon as I try to up the JRuby version to `9.4.x' it does not and fail with the below error. As per my understanding
this will work with Ruby version 3.1.x.

```
Caused by: org.jruby.exceptions.ArgumentError: (ArgumentError) wrong number of arguments (given 1, expected 0)
	at RUBY.initialize(uri:classloader:/gems/asciidoctor-interdoc-reftext-0.5.3/lib/asciidoctor/interdoc_reftext/processor.rb:66)
	at org.jruby.RubyClass.new(org/jruby/RubyClass.java:922)
	at RUBY.add_document_processor(uri:classloader:/gems/asciidoctor-2.0.23/lib/asciidoctor/extensions.rb:1387)
	at RUBY.tree_processor(uri:classloader:/gems/asciidoctor-2.0.23/lib/asciidoctor/extensions.rb:844)
	at RUBY.<main>(uri:classloader:/gems/asciidoctor-interdoc-reftext-0.5.3/lib/asciidoctor/interdoc_reftext.rb:10)
	at org.jruby.RubyBasicObject.instance_exec(org/jruby/RubyBasicObject.java:2620)
	at RUBY.activate(uri:classloader:/gems/asciidoctor-2.0.23/lib/asciidoctor/extensions.rb:744)
	at org.jruby.RubyArray.each(org/jruby/RubyArray.java:1981)
	at RUBY.activate(uri:classloader:/gems/asciidoctor-2.0.23/lib/asciidoctor/extensions.rb:739)
	at RUBY.initialize(uri:classloader:/gems/asciidoctor-2.0.23/lib/asciidoctor/document.rb:498)
	at org.jruby.RubyClass.new(org/jruby/RubyClass.java:935)
	at RUBY.load(uri:classloader:/gems/asciidoctor-2.0.23/lib/asciidoctor/load.rb:84)
```

I have no idea how to set the ruby version. I can see in the `processor.rb` that the error occurs on the `super`
instructor call.

```ruby

def initialize(resolver_class: Resolver, **resolver_opts)
  super
  @resolver_class = resolver_class
  @resolver_opts = resolver_opts
```

I know that in later versions of ruby you have to add `()` to the super calls. But my knowledge of ruby is just too
little to know how to solve this.

Any ideas?

## To try it out

In the [build.gradle.kts](build.gradle.kts) look at the TODO's. There are 2 TODO's where the version needs to be
switched to make it work or break it by commenting and uncommenting the lines.
