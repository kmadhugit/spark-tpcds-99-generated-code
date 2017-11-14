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
/* 014 */     result = new UnsafeRow(11);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 11);
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
/* 028 */     boolean isNull5 = i.isNullAt(5);
/* 029 */     double value5 = isNull5 ? -1.0 : (i.getDouble(5));
/* 030 */     if (isNull5) {
/* 031 */       rowWriter.setNullAt(5);
/* 032 */     } else {
/* 033 */       rowWriter.write(5, value5);
/* 034 */     }
/* 035 */
/* 036 */
/* 037 */     boolean isNull6 = i.isNullAt(6);
/* 038 */     int value6 = isNull6 ? -1 : (i.getInt(6));
/* 039 */     if (isNull6) {
/* 040 */       rowWriter.setNullAt(6);
/* 041 */     } else {
/* 042 */       rowWriter.write(6, value6);
/* 043 */     }
/* 044 */
/* 045 */
/* 046 */     boolean isNull7 = i.isNullAt(7);
/* 047 */     int value7 = isNull7 ? -1 : (i.getInt(7));
/* 048 */     if (isNull7) {
/* 049 */       rowWriter.setNullAt(7);
/* 050 */     } else {
/* 051 */       rowWriter.write(7, value7);
/* 052 */     }
/* 053 */
/* 054 */
/* 055 */     boolean isNull8 = i.isNullAt(8);
/* 056 */     int value8 = isNull8 ? -1 : (i.getInt(8));
/* 057 */     if (isNull8) {
/* 058 */       rowWriter.setNullAt(8);
/* 059 */     } else {
/* 060 */       rowWriter.write(8, value8);
/* 061 */     }
/* 062 */
/* 063 */
/* 064 */     boolean isNull9 = i.isNullAt(9);
/* 065 */     double value9 = isNull9 ? -1.0 : (i.getDouble(9));
/* 066 */     if (isNull9) {
/* 067 */       rowWriter.setNullAt(9);
/* 068 */     } else {
/* 069 */       rowWriter.write(9, value9);
/* 070 */     }
/* 071 */
/* 072 */   }
/* 073 */
/* 074 */
/* 075 */   private void apply_0(InternalRow i) {
/* 076 */
/* 077 */
/* 078 */     boolean isNull = i.isNullAt(0);
/* 079 */     int value = isNull ? -1 : (i.getInt(0));
/* 080 */     if (isNull) {
/* 081 */       rowWriter.setNullAt(0);
/* 082 */     } else {
/* 083 */       rowWriter.write(0, value);
/* 084 */     }
/* 085 */
/* 086 */
/* 087 */     boolean isNull1 = i.isNullAt(1);
/* 088 */     int value1 = isNull1 ? -1 : (i.getInt(1));
/* 089 */     if (isNull1) {
/* 090 */       rowWriter.setNullAt(1);
/* 091 */     } else {
/* 092 */       rowWriter.write(1, value1);
/* 093 */     }
/* 094 */
/* 095 */
/* 096 */     boolean isNull2 = i.isNullAt(2);
/* 097 */     int value2 = isNull2 ? -1 : (i.getInt(2));
/* 098 */     if (isNull2) {
/* 099 */       rowWriter.setNullAt(2);
/* 100 */     } else {
/* 101 */       rowWriter.write(2, value2);
/* 102 */     }
/* 103 */
/* 104 */
/* 105 */     boolean isNull3 = i.isNullAt(3);
/* 106 */     int value3 = isNull3 ? -1 : (i.getInt(3));
/* 107 */     if (isNull3) {
/* 108 */       rowWriter.setNullAt(3);
/* 109 */     } else {
/* 110 */       rowWriter.write(3, value3);
/* 111 */     }
/* 112 */
/* 113 */
/* 114 */     boolean isNull4 = i.isNullAt(4);
/* 115 */     double value4 = isNull4 ? -1.0 : (i.getDouble(4));
/* 116 */     if (isNull4) {
/* 117 */       rowWriter.setNullAt(4);
/* 118 */     } else {
/* 119 */       rowWriter.write(4, value4);
/* 120 */     }
/* 121 */
/* 122 */   }
/* 123 */
/* 124 */
/* 125 */   private void apply_2(InternalRow i) {
/* 126 */
/* 127 */
/* 128 */     boolean isNull10 = i.isNullAt(10);
/* 129 */     double value10 = isNull10 ? -1.0 : (i.getDouble(10));
/* 130 */     if (isNull10) {
/* 131 */       rowWriter.setNullAt(10);
/* 132 */     } else {
/* 133 */       rowWriter.write(10, value10);
/* 134 */     }
/* 135 */
/* 136 */   }
/* 137 */
/* 138 */
/* 139 */   // Scala.Function1 need this
/* 140 */   public java.lang.Object apply(java.lang.Object row) {
/* 141 */     return apply((InternalRow) row);
/* 142 */   }
/* 143 */
/* 144 */   public UnsafeRow apply(InternalRow i) {
/* 145 */     rowWriter.zeroOutNullBytes();
/* 146 */     apply_0(i);
/* 147 */     apply_1(i);
/* 148 */     apply_2(i);
/* 149 */     return result;
/* 150 */   }
/* 151 */ }
