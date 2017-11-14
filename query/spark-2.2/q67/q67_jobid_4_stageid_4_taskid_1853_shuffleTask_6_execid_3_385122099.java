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
/* 030 */     int value6 = isNull6 ? -1 : (i.getInt(4));
/* 031 */     if (!isNull6) {
/* 032 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value6, value1);
/* 033 */     }
/* 034 */
/* 035 */     boolean isNull7 = i.isNullAt(5);
/* 036 */     int value7 = isNull7 ? -1 : (i.getInt(5));
/* 037 */     if (!isNull7) {
/* 038 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value7, value1);
/* 039 */     }
/* 040 */
/* 041 */     boolean isNull8 = i.isNullAt(6);
/* 042 */     int value8 = isNull8 ? -1 : (i.getInt(6));
/* 043 */     if (!isNull8) {
/* 044 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value8, value1);
/* 045 */     }
/* 046 */
/* 047 */     boolean isNull9 = i.isNullAt(7);
/* 048 */     UTF8String value9 = isNull9 ? null : (i.getUTF8String(7));
/* 049 */     if (!isNull9) {
/* 050 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value9.getBaseObject(), value9.getBaseOffset(), value9.numBytes(), value1);
/* 051 */     }
/* 052 */
/* 053 */     int value10 = i.getInt(8);
/* 054 */     value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value10, value1);
/* 055 */   }
/* 056 */
/* 057 */
/* 058 */   private void apply_0(InternalRow i) {
/* 059 */
/* 060 */     boolean isNull2 = i.isNullAt(0);
/* 061 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 062 */     if (!isNull2) {
/* 063 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value2.getBaseObject(), value2.getBaseOffset(), value2.numBytes(), value1);
/* 064 */     }
/* 065 */
/* 066 */     boolean isNull3 = i.isNullAt(1);
/* 067 */     UTF8String value3 = isNull3 ? null : (i.getUTF8String(1));
/* 068 */     if (!isNull3) {
/* 069 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value3.getBaseObject(), value3.getBaseOffset(), value3.numBytes(), value1);
/* 070 */     }
/* 071 */
/* 072 */     boolean isNull4 = i.isNullAt(2);
/* 073 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(2));
/* 074 */     if (!isNull4) {
/* 075 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value4.getBaseObject(), value4.getBaseOffset(), value4.numBytes(), value1);
/* 076 */     }
/* 077 */
/* 078 */     boolean isNull5 = i.isNullAt(3);
/* 079 */     UTF8String value5 = isNull5 ? null : (i.getUTF8String(3));
/* 080 */     if (!isNull5) {
/* 081 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value5.getBaseObject(), value5.getBaseOffset(), value5.numBytes(), value1);
/* 082 */     }
/* 083 */
/* 084 */   }
/* 085 */
/* 086 */
/* 087 */   // Scala.Function1 need this
/* 088 */   public java.lang.Object apply(java.lang.Object row) {
/* 089 */     return apply((InternalRow) row);
/* 090 */   }
/* 091 */
/* 092 */   public UnsafeRow apply(InternalRow i) {
/* 093 */     boolean isNull = false;
/* 094 */
/* 095 */     value1 = 42;
/* 096 */     apply_0(i);
/* 097 */     apply_1(i);
/* 098 */
/* 099 */     int value = -1;
/* 100 */
/* 101 */     int remainder = value1 % 64;
/* 102 */     if (remainder < 0) {
/* 103 */       value = (remainder + 64) % 64;
/* 104 */     } else {
/* 105 */       value = remainder;
/* 106 */     }
/* 107 */     rowWriter.write(0, value);
/* 108 */     return result;
/* 109 */   }
/* 110 */ }
