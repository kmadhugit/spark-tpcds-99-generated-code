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
/* 014 */     result = new UnsafeRow(17);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 96);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 17);
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
/* 029 */     int value5 = isNull5 ? -1 : (i.getInt(5));
/* 030 */     if (isNull5) {
/* 031 */       rowWriter.setNullAt(5);
/* 032 */     } else {
/* 033 */       rowWriter.write(5, value5);
/* 034 */     }
/* 035 */
/* 036 */
/* 037 */     boolean isNull6 = i.isNullAt(6);
/* 038 */     double value6 = isNull6 ? -1.0 : (i.getDouble(6));
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
/* 055 */     long value8 = i.getLong(8);
/* 056 */     rowWriter.write(8, value8);
/* 057 */
/* 058 */
/* 059 */     boolean isNull9 = i.isNullAt(9);
/* 060 */     int value9 = isNull9 ? -1 : (i.getInt(9));
/* 061 */     if (isNull9) {
/* 062 */       rowWriter.setNullAt(9);
/* 063 */     } else {
/* 064 */       rowWriter.write(9, value9);
/* 065 */     }
/* 066 */
/* 067 */   }
/* 068 */
/* 069 */
/* 070 */   private void apply_3(InternalRow i) {
/* 071 */
/* 072 */
/* 073 */     boolean isNull15 = i.isNullAt(15);
/* 074 */     int value15 = isNull15 ? -1 : (i.getInt(15));
/* 075 */     if (isNull15) {
/* 076 */       rowWriter.setNullAt(15);
/* 077 */     } else {
/* 078 */       rowWriter.write(15, value15);
/* 079 */     }
/* 080 */
/* 081 */
/* 082 */     boolean isNull16 = i.isNullAt(16);
/* 083 */     double value16 = isNull16 ? -1.0 : (i.getDouble(16));
/* 084 */     if (isNull16) {
/* 085 */       rowWriter.setNullAt(16);
/* 086 */     } else {
/* 087 */       rowWriter.write(16, value16);
/* 088 */     }
/* 089 */
/* 090 */   }
/* 091 */
/* 092 */
/* 093 */   private void apply_0(InternalRow i) {
/* 094 */
/* 095 */
/* 096 */     boolean isNull = i.isNullAt(0);
/* 097 */     UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 098 */     if (isNull) {
/* 099 */       rowWriter.setNullAt(0);
/* 100 */     } else {
/* 101 */       rowWriter.write(0, value);
/* 102 */     }
/* 103 */
/* 104 */
/* 105 */     boolean isNull1 = i.isNullAt(1);
/* 106 */     UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 107 */     if (isNull1) {
/* 108 */       rowWriter.setNullAt(1);
/* 109 */     } else {
/* 110 */       rowWriter.write(1, value1);
/* 111 */     }
/* 112 */
/* 113 */
/* 114 */     boolean isNull2 = i.isNullAt(2);
/* 115 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 116 */     if (isNull2) {
/* 117 */       rowWriter.setNullAt(2);
/* 118 */     } else {
/* 119 */       rowWriter.write(2, value2);
/* 120 */     }
/* 121 */
/* 122 */
/* 123 */     long value3 = i.getLong(3);
/* 124 */     rowWriter.write(3, value3);
/* 125 */
/* 126 */
/* 127 */     boolean isNull4 = i.isNullAt(4);
/* 128 */     int value4 = isNull4 ? -1 : (i.getInt(4));
/* 129 */     if (isNull4) {
/* 130 */       rowWriter.setNullAt(4);
/* 131 */     } else {
/* 132 */       rowWriter.write(4, value4);
/* 133 */     }
/* 134 */
/* 135 */   }
/* 136 */
/* 137 */
/* 138 */   private void apply_2(InternalRow i) {
/* 139 */
/* 140 */
/* 141 */     boolean isNull10 = i.isNullAt(10);
/* 142 */     int value10 = isNull10 ? -1 : (i.getInt(10));
/* 143 */     if (isNull10) {
/* 144 */       rowWriter.setNullAt(10);
/* 145 */     } else {
/* 146 */       rowWriter.write(10, value10);
/* 147 */     }
/* 148 */
/* 149 */
/* 150 */     boolean isNull11 = i.isNullAt(11);
/* 151 */     double value11 = isNull11 ? -1.0 : (i.getDouble(11));
/* 152 */     if (isNull11) {
/* 153 */       rowWriter.setNullAt(11);
/* 154 */     } else {
/* 155 */       rowWriter.write(11, value11);
/* 156 */     }
/* 157 */
/* 158 */
/* 159 */     boolean isNull12 = i.isNullAt(12);
/* 160 */     int value12 = isNull12 ? -1 : (i.getInt(12));
/* 161 */     if (isNull12) {
/* 162 */       rowWriter.setNullAt(12);
/* 163 */     } else {
/* 164 */       rowWriter.write(12, value12);
/* 165 */     }
/* 166 */
/* 167 */
/* 168 */     long value13 = i.getLong(13);
/* 169 */     rowWriter.write(13, value13);
/* 170 */
/* 171 */
/* 172 */     boolean isNull14 = i.isNullAt(14);
/* 173 */     int value14 = isNull14 ? -1 : (i.getInt(14));
/* 174 */     if (isNull14) {
/* 175 */       rowWriter.setNullAt(14);
/* 176 */     } else {
/* 177 */       rowWriter.write(14, value14);
/* 178 */     }
/* 179 */
/* 180 */   }
/* 181 */
/* 182 */
/* 183 */   // Scala.Function1 need this
/* 184 */   public java.lang.Object apply(java.lang.Object row) {
/* 185 */     return apply((InternalRow) row);
/* 186 */   }
/* 187 */
/* 188 */   public UnsafeRow apply(InternalRow i) {
/* 189 */     holder.reset();
/* 190 */
/* 191 */     rowWriter.zeroOutNullBytes();
/* 192 */     apply_0(i);
/* 193 */     apply_1(i);
/* 194 */     apply_2(i);
/* 195 */     apply_3(i);
/* 196 */     result.setTotalSize(holder.totalSize());
/* 197 */     return result;
/* 198 */   }
/* 199 */ }
