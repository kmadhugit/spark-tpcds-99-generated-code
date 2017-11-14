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
/* 014 */     result = new UnsafeRow(35);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 35);
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
/* 028 */     rowWriter.write(10, 0L);
/* 029 */
/* 030 */
/* 031 */     rowWriter.write(11, 0L);
/* 032 */
/* 033 */
/* 034 */     boolean isNull14 = false;
/* 035 */     double value14 = -1.0;
/* 036 */     if (!false) {
/* 037 */       value14 = (double) 0;
/* 038 */     }
/* 039 */     if (isNull14) {
/* 040 */       rowWriter.setNullAt(12);
/* 041 */     } else {
/* 042 */       rowWriter.write(12, value14);
/* 043 */     }
/* 044 */
/* 045 */
/* 046 */     rowWriter.write(13, 0L);
/* 047 */
/* 048 */
/* 049 */     rowWriter.write(14, 0.0D);
/* 050 */
/* 051 */
/* 052 */     rowWriter.write(15, 0.0D);
/* 053 */
/* 054 */
/* 055 */     rowWriter.write(16, 0.0D);
/* 056 */
/* 057 */
/* 058 */     rowWriter.write(17, 0.0D);
/* 059 */
/* 060 */
/* 061 */     rowWriter.write(18, 0.0D);
/* 062 */
/* 063 */
/* 064 */     rowWriter.write(19, 0.0D);
/* 065 */
/* 066 */
/* 067 */     boolean isNull23 = false;
/* 068 */     double value23 = -1.0;
/* 069 */     if (!false) {
/* 070 */       value23 = (double) 0;
/* 071 */     }
/* 072 */     if (isNull23) {
/* 073 */       rowWriter.setNullAt(20);
/* 074 */     } else {
/* 075 */       rowWriter.write(20, value23);
/* 076 */     }
/* 077 */
/* 078 */   }
/* 079 */
/* 080 */
/* 081 */   private void apply_3(InternalRow i) {
/* 082 */
/* 083 */
/* 084 */     rowWriter.write(31, 0.0D);
/* 085 */
/* 086 */
/* 087 */     rowWriter.write(32, 0.0D);
/* 088 */
/* 089 */
/* 090 */     boolean isNull39 = false;
/* 091 */     double value39 = -1.0;
/* 092 */     if (!false) {
/* 093 */       value39 = (double) 0;
/* 094 */     }
/* 095 */     if (isNull39) {
/* 096 */       rowWriter.setNullAt(33);
/* 097 */     } else {
/* 098 */       rowWriter.write(33, value39);
/* 099 */     }
/* 100 */
/* 101 */
/* 102 */     rowWriter.write(34, 0L);
/* 103 */
/* 104 */   }
/* 105 */
/* 106 */
/* 107 */   private void apply_0(InternalRow i) {
/* 108 */
/* 109 */
/* 110 */     rowWriter.write(0, 0L);
/* 111 */
/* 112 */
/* 113 */     boolean isNull1 = false;
/* 114 */     double value1 = -1.0;
/* 115 */     if (!false) {
/* 116 */       value1 = (double) 0;
/* 117 */     }
/* 118 */     if (isNull1) {
/* 119 */       rowWriter.setNullAt(1);
/* 120 */     } else {
/* 121 */       rowWriter.write(1, value1);
/* 122 */     }
/* 123 */
/* 124 */
/* 125 */     rowWriter.write(2, 0L);
/* 126 */
/* 127 */
/* 128 */     rowWriter.write(3, 0.0D);
/* 129 */
/* 130 */
/* 131 */     rowWriter.write(4, 0.0D);
/* 132 */
/* 133 */
/* 134 */     rowWriter.write(5, 0.0D);
/* 135 */
/* 136 */
/* 137 */     rowWriter.write(6, 0.0D);
/* 138 */
/* 139 */
/* 140 */     rowWriter.write(7, 0.0D);
/* 141 */
/* 142 */
/* 143 */     rowWriter.write(8, 0.0D);
/* 144 */
/* 145 */
/* 146 */     boolean isNull10 = false;
/* 147 */     double value10 = -1.0;
/* 148 */     if (!false) {
/* 149 */       value10 = (double) 0;
/* 150 */     }
/* 151 */     if (isNull10) {
/* 152 */       rowWriter.setNullAt(9);
/* 153 */     } else {
/* 154 */       rowWriter.write(9, value10);
/* 155 */     }
/* 156 */
/* 157 */   }
/* 158 */
/* 159 */
/* 160 */   private void apply_2(InternalRow i) {
/* 161 */
/* 162 */
/* 163 */     rowWriter.write(21, 0L);
/* 164 */
/* 165 */
/* 166 */     rowWriter.write(22, 0L);
/* 167 */
/* 168 */
/* 169 */     boolean isNull27 = false;
/* 170 */     double value27 = -1.0;
/* 171 */     if (!false) {
/* 172 */       value27 = (double) 0;
/* 173 */     }
/* 174 */     if (isNull27) {
/* 175 */       rowWriter.setNullAt(23);
/* 176 */     } else {
/* 177 */       rowWriter.write(23, value27);
/* 178 */     }
/* 179 */
/* 180 */
/* 181 */     rowWriter.write(24, 0L);
/* 182 */
/* 183 */
/* 184 */     rowWriter.write(25, 0.0D);
/* 185 */
/* 186 */
/* 187 */     rowWriter.write(26, 0.0D);
/* 188 */
/* 189 */
/* 190 */     rowWriter.write(27, 0.0D);
/* 191 */
/* 192 */
/* 193 */     boolean isNull33 = false;
/* 194 */     double value33 = -1.0;
/* 195 */     if (!false) {
/* 196 */       value33 = (double) 0;
/* 197 */     }
/* 198 */     if (isNull33) {
/* 199 */       rowWriter.setNullAt(28);
/* 200 */     } else {
/* 201 */       rowWriter.write(28, value33);
/* 202 */     }
/* 203 */
/* 204 */
/* 205 */     rowWriter.write(29, 0L);
/* 206 */
/* 207 */
/* 208 */     rowWriter.write(30, 0.0D);
/* 209 */
/* 210 */   }
/* 211 */
/* 212 */
/* 213 */   // Scala.Function1 need this
/* 214 */   public java.lang.Object apply(java.lang.Object row) {
/* 215 */     return apply((InternalRow) row);
/* 216 */   }
/* 217 */
/* 218 */   public UnsafeRow apply(InternalRow i) {
/* 219 */     rowWriter.zeroOutNullBytes();
/* 220 */     apply_0(i);
/* 221 */     apply_1(i);
/* 222 */     apply_2(i);
/* 223 */     apply_3(i);
/* 224 */     return result;
/* 225 */   }
/* 226 */ }
