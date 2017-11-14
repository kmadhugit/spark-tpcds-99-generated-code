/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private UnsafeRow result;
/* 009 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder holder;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter;
/* 011 */
/* 012 */   public SpecificUnsafeProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     result = new UnsafeRow(10);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 128);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 10);
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */   private void apply_1(InternalRow i) {
/* 026 */
/* 027 */
/* 028 */     int value4 = i.getInt(4);
/* 029 */     rowWriter.write(4, value4);
/* 030 */
/* 031 */
/* 032 */     boolean isNull5 = i.isNullAt(5);
/* 033 */     int value5 = isNull5 ? -1 : (i.getInt(5));
/* 034 */     if (isNull5) {
/* 035 */       rowWriter.setNullAt(5);
/* 036 */     } else {
/* 037 */       rowWriter.write(5, value5);
/* 038 */     }
/* 039 */
/* 040 */
/* 041 */     boolean isNull6 = i.isNullAt(6);
/* 042 */     double value6 = isNull6 ? -1.0 : (i.getDouble(6));
/* 043 */     if (isNull6) {
/* 044 */       rowWriter.setNullAt(6);
/* 045 */     } else {
/* 046 */       rowWriter.write(6, value6);
/* 047 */     }
/* 048 */
/* 049 */
/* 050 */     boolean isNull7 = i.isNullAt(7);
/* 051 */     double value7 = isNull7 ? -1.0 : (i.getDouble(7));
/* 052 */     if (isNull7) {
/* 053 */       rowWriter.setNullAt(7);
/* 054 */     } else {
/* 055 */       rowWriter.write(7, value7);
/* 056 */     }
/* 057 */
/* 058 */
/* 059 */     boolean isNull8 = i.isNullAt(8);
/* 060 */     int value8 = isNull8 ? -1 : (i.getInt(8));
/* 061 */     if (isNull8) {
/* 062 */       rowWriter.setNullAt(8);
/* 063 */     } else {
/* 064 */       rowWriter.write(8, value8);
/* 065 */     }
/* 066 */
/* 067 */   }
/* 068 */
/* 069 */
/* 070 */   private void apply_0(InternalRow i) {
/* 071 */
/* 072 */
/* 073 */     boolean isNull = i.isNullAt(0);
/* 074 */     UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 075 */     if (isNull) {
/* 076 */       rowWriter.setNullAt(0);
/* 077 */     } else {
/* 078 */       rowWriter.write(0, value);
/* 079 */     }
/* 080 */
/* 081 */
/* 082 */     boolean isNull1 = i.isNullAt(1);
/* 083 */     UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 084 */     if (isNull1) {
/* 085 */       rowWriter.setNullAt(1);
/* 086 */     } else {
/* 087 */       rowWriter.write(1, value1);
/* 088 */     }
/* 089 */
/* 090 */
/* 091 */     boolean isNull2 = i.isNullAt(2);
/* 092 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 093 */     if (isNull2) {
/* 094 */       rowWriter.setNullAt(2);
/* 095 */     } else {
/* 096 */       rowWriter.write(2, value2);
/* 097 */     }
/* 098 */
/* 099 */
/* 100 */     boolean isNull3 = i.isNullAt(3);
/* 101 */     UTF8String value3 = isNull3 ? null : (i.getUTF8String(3));
/* 102 */     if (isNull3) {
/* 103 */       rowWriter.setNullAt(3);
/* 104 */     } else {
/* 105 */       rowWriter.write(3, value3);
/* 106 */     }
/* 107 */
/* 108 */   }
/* 109 */
/* 110 */
/* 111 */   private void apply_2(InternalRow i) {
/* 112 */
/* 113 */
/* 114 */     boolean isNull9 = i.isNullAt(9);
/* 115 */     double value9 = isNull9 ? -1.0 : (i.getDouble(9));
/* 116 */     if (isNull9) {
/* 117 */       rowWriter.setNullAt(9);
/* 118 */     } else {
/* 119 */       rowWriter.write(9, value9);
/* 120 */     }
/* 121 */
/* 122 */   }
/* 123 */
/* 124 */
/* 125 */   // Scala.Function1 need this
/* 126 */   public java.lang.Object apply(java.lang.Object row) {
/* 127 */     return apply((InternalRow) row);
/* 128 */   }
/* 129 */
/* 130 */   public UnsafeRow apply(InternalRow i) {
/* 131 */     holder.reset();
/* 132 */
/* 133 */     rowWriter.zeroOutNullBytes();
/* 134 */     apply_0(i);
/* 135 */     apply_1(i);
/* 136 */     apply_2(i);
/* 137 */     result.setTotalSize(holder.totalSize());
/* 138 */     return result;
/* 139 */   }
/* 140 */ }
