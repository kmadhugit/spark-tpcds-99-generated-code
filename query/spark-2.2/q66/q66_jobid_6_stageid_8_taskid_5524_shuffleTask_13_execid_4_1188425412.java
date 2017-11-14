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
/* 041 */     UTF8String value8 = i.getUTF8String(6);
/* 042 */     value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value8.getBaseObject(), value8.getBaseOffset(), value8.numBytes(), value1);
/* 043 */     boolean isNull9 = i.isNullAt(7);
/* 044 */     int value9 = isNull9 ? -1 : (i.getInt(7));
/* 045 */     if (!isNull9) {
/* 046 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value9, value1);
/* 047 */     }
/* 048 */
/* 049 */   }
/* 050 */
/* 051 */
/* 052 */   private void apply_0(InternalRow i) {
/* 053 */
/* 054 */     boolean isNull2 = i.isNullAt(0);
/* 055 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 056 */     if (!isNull2) {
/* 057 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value2.getBaseObject(), value2.getBaseOffset(), value2.numBytes(), value1);
/* 058 */     }
/* 059 */
/* 060 */     boolean isNull3 = i.isNullAt(1);
/* 061 */     int value3 = isNull3 ? -1 : (i.getInt(1));
/* 062 */     if (!isNull3) {
/* 063 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value3, value1);
/* 064 */     }
/* 065 */
/* 066 */     boolean isNull4 = i.isNullAt(2);
/* 067 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(2));
/* 068 */     if (!isNull4) {
/* 069 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value4.getBaseObject(), value4.getBaseOffset(), value4.numBytes(), value1);
/* 070 */     }
/* 071 */
/* 072 */     boolean isNull5 = i.isNullAt(3);
/* 073 */     UTF8String value5 = isNull5 ? null : (i.getUTF8String(3));
/* 074 */     if (!isNull5) {
/* 075 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value5.getBaseObject(), value5.getBaseOffset(), value5.numBytes(), value1);
/* 076 */     }
/* 077 */
/* 078 */   }
/* 079 */
/* 080 */
/* 081 */   // Scala.Function1 need this
/* 082 */   public java.lang.Object apply(java.lang.Object row) {
/* 083 */     return apply((InternalRow) row);
/* 084 */   }
/* 085 */
/* 086 */   public UnsafeRow apply(InternalRow i) {
/* 087 */     boolean isNull = false;
/* 088 */
/* 089 */     value1 = 42;
/* 090 */     apply_0(i);
/* 091 */     apply_1(i);
/* 092 */
/* 093 */     int value = -1;
/* 094 */
/* 095 */     int remainder = value1 % 64;
/* 096 */     if (remainder < 0) {
/* 097 */       value = (remainder + 64) % 64;
/* 098 */     } else {
/* 099 */       value = remainder;
/* 100 */     }
/* 101 */     rowWriter.write(0, value);
/* 102 */     return result;
/* 103 */   }
/* 104 */ }
