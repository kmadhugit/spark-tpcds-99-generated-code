/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private int value1;
/* 009 */   private UnsafeRow result;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder holder;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter;
/* 012 */
/* 013 */   public SpecificUnsafeProjection(Object[] references) {
/* 014 */     this.references = references;
/* 015 */
/* 016 */     result = new UnsafeRow(1);
/* 017 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 018 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 1);
/* 019 */
/* 020 */   }
/* 021 */
/* 022 */   public void initialize(int partitionIndex) {
/* 023 */
/* 024 */   }
/* 025 */
/* 026 */
/* 027 */   private void apply_1(InternalRow i) {
/* 028 */
/* 029 */     boolean isNull6 = i.isNullAt(4);
/* 030 */     UTF8String value6 = isNull6 ? null : (i.getUTF8String(4));
/* 031 */     if (!isNull6) {
/* 032 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value6.getBaseObject(), value6.getBaseOffset(), value6.numBytes(), value1);
/* 033 */     }
/* 034 */
/* 035 */     boolean isNull7 = i.isNullAt(5);
/* 036 */     UTF8String value7 = isNull7 ? null : (i.getUTF8String(5));
/* 037 */     if (!isNull7) {
/* 038 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value7.getBaseObject(), value7.getBaseOffset(), value7.numBytes(), value1);
/* 039 */     }
/* 040 */
/* 041 */     boolean isNull8 = i.isNullAt(6);
/* 042 */     UTF8String value8 = isNull8 ? null : (i.getUTF8String(6));
/* 043 */     if (!isNull8) {
/* 044 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value8.getBaseObject(), value8.getBaseOffset(), value8.numBytes(), value1);
/* 045 */     }
/* 046 */
/* 047 */     boolean isNull9 = i.isNullAt(7);
/* 048 */     UTF8String value9 = isNull9 ? null : (i.getUTF8String(7));
/* 049 */     if (!isNull9) {
/* 050 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value9.getBaseObject(), value9.getBaseOffset(), value9.numBytes(), value1);
/* 051 */     }
/* 052 */
/* 053 */   }
/* 054 */
/* 055 */
/* 056 */   private void apply_0(InternalRow i) {
/* 057 */
/* 058 */     boolean isNull2 = i.isNullAt(0);
/* 059 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 060 */     if (!isNull2) {
/* 061 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value2.getBaseObject(), value2.getBaseOffset(), value2.numBytes(), value1);
/* 062 */     }
/* 063 */
/* 064 */     boolean isNull3 = i.isNullAt(1);
/* 065 */     int value3 = isNull3 ? -1 : (i.getInt(1));
/* 066 */     if (!isNull3) {
/* 067 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value3, value1);
/* 068 */     }
/* 069 */
/* 070 */     boolean isNull4 = i.isNullAt(2);
/* 071 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(2));
/* 072 */     if (!isNull4) {
/* 073 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value4.getBaseObject(), value4.getBaseOffset(), value4.numBytes(), value1);
/* 074 */     }
/* 075 */
/* 076 */     boolean isNull5 = i.isNullAt(3);
/* 077 */     UTF8String value5 = isNull5 ? null : (i.getUTF8String(3));
/* 078 */     if (!isNull5) {
/* 079 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value5.getBaseObject(), value5.getBaseOffset(), value5.numBytes(), value1);
/* 080 */     }
/* 081 */
/* 082 */   }
/* 083 */
/* 084 */
/* 085 */   private void apply_2(InternalRow i) {
/* 086 */
/* 087 */     boolean isNull10 = i.isNullAt(8);
/* 088 */     UTF8String value10 = isNull10 ? null : (i.getUTF8String(8));
/* 089 */     if (!isNull10) {
/* 090 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value10.getBaseObject(), value10.getBaseOffset(), value10.numBytes(), value1);
/* 091 */     }
/* 092 */
/* 093 */     boolean isNull11 = i.isNullAt(9);
/* 094 */     UTF8String value11 = isNull11 ? null : (i.getUTF8String(9));
/* 095 */     if (!isNull11) {
/* 096 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value11.getBaseObject(), value11.getBaseOffset(), value11.numBytes(), value1);
/* 097 */     }
/* 098 */
/* 099 */   }
/* 100 */
/* 101 */
/* 102 */   // Scala.Function1 need this
/* 103 */   public java.lang.Object apply(java.lang.Object row) {
/* 104 */     return apply((InternalRow) row);
/* 105 */   }
/* 106 */
/* 107 */   public UnsafeRow apply(InternalRow i) {
/* 108 */     boolean isNull = false;
/* 109 */
/* 110 */     value1 = 42;
/* 111 */     apply_0(i);
/* 112 */     apply_1(i);
/* 113 */     apply_2(i);
/* 114 */
/* 115 */     int value = -1;
/* 116 */
/* 117 */     int remainder = value1 % 64;
/* 118 */     if (remainder < 0) {
/* 119 */       value = (remainder + 64) % 64;
/* 120 */     } else {
/* 121 */       value = remainder;
/* 122 */     }
/* 123 */     rowWriter.write(0, value);
/* 124 */     return result;
/* 125 */   }
/* 126 */ }
