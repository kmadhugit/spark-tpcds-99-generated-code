/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator smj_leftInput;
/* 009 */   private scala.collection.Iterator smj_rightInput;
/* 010 */   private InternalRow smj_leftRow;
/* 011 */   private InternalRow smj_rightRow;
/* 012 */   private long smj_value6;
/* 013 */   private long smj_value7;
/* 014 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 015 */   private long smj_value8;
/* 016 */   private long smj_value9;
/* 017 */   private int smj_value10;
/* 018 */   private boolean smj_isNull6;
/* 019 */   private int smj_value11;
/* 020 */   private boolean smj_isNull7;
/* 021 */   private int smj_value12;
/* 022 */   private boolean smj_isNull8;
/* 023 */   private int smj_value13;
/* 024 */   private boolean smj_isNull9;
/* 025 */   private int smj_value14;
/* 026 */   private boolean smj_isNull10;
/* 027 */   private int smj_value15;
/* 028 */   private boolean smj_isNull11;
/* 029 */   private int smj_value16;
/* 030 */   private boolean smj_isNull12;
/* 031 */   private int smj_value17;
/* 032 */   private boolean smj_isNull13;
/* 033 */   private double smj_value18;
/* 034 */   private boolean smj_isNull14;
/* 035 */   private double smj_value19;
/* 036 */   private boolean smj_isNull15;
/* 037 */   private double smj_value20;
/* 038 */   private boolean smj_isNull16;
/* 039 */   private int smj_value21;
/* 040 */   private boolean smj_isNull17;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 042 */   private UnsafeRow smj_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 045 */   private UnsafeRow project_result;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 048 */
/* 049 */   public GeneratedIterator(Object[] references) {
/* 050 */     this.references = references;
/* 051 */   }
/* 052 */
/* 053 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 054 */     partitionIndex = index;
/* 055 */     this.inputs = inputs;
/* 056 */     smj_leftInput = inputs[0];
/* 057 */     smj_rightInput = inputs[1];
/* 058 */
/* 059 */     smj_rightRow = null;
/* 060 */
/* 061 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 062 */
/* 063 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 064 */     smj_result = new UnsafeRow(14);
/* 065 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 066 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 14);
/* 067 */     project_result = new UnsafeRow(11);
/* 068 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 069 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 11);
/* 070 */
/* 071 */   }
/* 072 */
/* 073 */   private boolean findNextInnerJoinRows(
/* 074 */     scala.collection.Iterator leftIter,
/* 075 */     scala.collection.Iterator rightIter) {
/* 076 */     smj_leftRow = null;
/* 077 */     int comp = 0;
/* 078 */     while (smj_leftRow == null) {
/* 079 */       if (!leftIter.hasNext()) return false;
/* 080 */       smj_leftRow = (InternalRow) leftIter.next();
/* 081 */
/* 082 */       boolean smj_isNull1 = smj_leftRow.isNullAt(0);
/* 083 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(0));
/* 084 */       boolean smj_isNull = smj_isNull1;
/* 085 */       long smj_value = -1L;
/* 086 */       if (!smj_isNull1) {
/* 087 */         smj_value = (long) smj_value1;
/* 088 */       }
/* 089 */
/* 090 */       boolean smj_isNull3 = smj_leftRow.isNullAt(7);
/* 091 */       int smj_value3 = smj_isNull3 ? -1 : (smj_leftRow.getInt(7));
/* 092 */       boolean smj_isNull2 = smj_isNull3;
/* 093 */       long smj_value2 = -1L;
/* 094 */       if (!smj_isNull3) {
/* 095 */         smj_value2 = (long) smj_value3;
/* 096 */       }
/* 097 */       if (smj_isNull || smj_isNull2) {
/* 098 */         smj_leftRow = null;
/* 099 */         continue;
/* 100 */       }
/* 101 */       if (!smj_matches.isEmpty()) {
/* 102 */         comp = 0;
/* 103 */         if (comp == 0) {
/* 104 */           comp = (smj_value > smj_value8 ? 1 : smj_value < smj_value8 ? -1 : 0);
/* 105 */         }
/* 106 */         if (comp == 0) {
/* 107 */           comp = (smj_value2 > smj_value9 ? 1 : smj_value2 < smj_value9 ? -1 : 0);
/* 108 */         }
/* 109 */
/* 110 */         if (comp == 0) {
/* 111 */           return true;
/* 112 */         }
/* 113 */         smj_matches.clear();
/* 114 */       }
/* 115 */
/* 116 */       do {
/* 117 */         if (smj_rightRow == null) {
/* 118 */           if (!rightIter.hasNext()) {
/* 119 */             smj_value8 = smj_value;
/* 120 */             smj_value9 = smj_value2;
/* 121 */             return !smj_matches.isEmpty();
/* 122 */           }
/* 123 */           smj_rightRow = (InternalRow) rightIter.next();
/* 124 */
/* 125 */           boolean smj_isNull4 = smj_rightRow.isNullAt(0);
/* 126 */           long smj_value4 = smj_isNull4 ? -1L : (smj_rightRow.getLong(0));
/* 127 */
/* 128 */           boolean smj_isNull5 = smj_rightRow.isNullAt(1);
/* 129 */           long smj_value5 = smj_isNull5 ? -1L : (smj_rightRow.getLong(1));
/* 130 */           if (smj_isNull4 || smj_isNull5) {
/* 131 */             smj_rightRow = null;
/* 132 */             continue;
/* 133 */           }
/* 134 */           smj_value6 = smj_value4;
/* 135 */           smj_value7 = smj_value5;
/* 136 */         }
/* 137 */
/* 138 */         comp = 0;
/* 139 */         if (comp == 0) {
/* 140 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 141 */         }
/* 142 */         if (comp == 0) {
/* 143 */           comp = (smj_value2 > smj_value7 ? 1 : smj_value2 < smj_value7 ? -1 : 0);
/* 144 */         }
/* 145 */
/* 146 */         if (comp > 0) {
/* 147 */           smj_rightRow = null;
/* 148 */         } else if (comp < 0) {
/* 149 */           if (!smj_matches.isEmpty()) {
/* 150 */             smj_value8 = smj_value;
/* 151 */             smj_value9 = smj_value2;
/* 152 */             return true;
/* 153 */           }
/* 154 */           smj_leftRow = null;
/* 155 */         } else {
/* 156 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 157 */           smj_rightRow = null;;
/* 158 */         }
/* 159 */       } while (smj_leftRow != null);
/* 160 */     }
/* 161 */     return false; // unreachable
/* 162 */   }
/* 163 */
/* 164 */   protected void processNext() throws java.io.IOException {
/* 165 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 166 */       smj_isNull6 = smj_leftRow.isNullAt(0);
/* 167 */       smj_value10 = smj_isNull6 ? -1 : (smj_leftRow.getInt(0));
/* 168 */       smj_isNull7 = smj_leftRow.isNullAt(1);
/* 169 */       smj_value11 = smj_isNull7 ? -1 : (smj_leftRow.getInt(1));
/* 170 */       smj_isNull8 = smj_leftRow.isNullAt(2);
/* 171 */       smj_value12 = smj_isNull8 ? -1 : (smj_leftRow.getInt(2));
/* 172 */       smj_isNull9 = smj_leftRow.isNullAt(3);
/* 173 */       smj_value13 = smj_isNull9 ? -1 : (smj_leftRow.getInt(3));
/* 174 */       smj_isNull10 = smj_leftRow.isNullAt(4);
/* 175 */       smj_value14 = smj_isNull10 ? -1 : (smj_leftRow.getInt(4));
/* 176 */       smj_isNull11 = smj_leftRow.isNullAt(5);
/* 177 */       smj_value15 = smj_isNull11 ? -1 : (smj_leftRow.getInt(5));
/* 178 */       smj_isNull12 = smj_leftRow.isNullAt(6);
/* 179 */       smj_value16 = smj_isNull12 ? -1 : (smj_leftRow.getInt(6));
/* 180 */       smj_isNull13 = smj_leftRow.isNullAt(7);
/* 181 */       smj_value17 = smj_isNull13 ? -1 : (smj_leftRow.getInt(7));
/* 182 */       smj_isNull14 = smj_leftRow.isNullAt(8);
/* 183 */       smj_value18 = smj_isNull14 ? -1.0 : (smj_leftRow.getDouble(8));
/* 184 */       smj_isNull15 = smj_leftRow.isNullAt(9);
/* 185 */       smj_value19 = smj_isNull15 ? -1.0 : (smj_leftRow.getDouble(9));
/* 186 */       smj_isNull16 = smj_leftRow.isNullAt(10);
/* 187 */       smj_value20 = smj_isNull16 ? -1.0 : (smj_leftRow.getDouble(10));
/* 188 */       smj_isNull17 = smj_leftRow.isNullAt(11);
/* 189 */       smj_value21 = smj_isNull17 ? -1 : (smj_leftRow.getInt(11));
/* 190 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 191 */       while (smj_iterator.hasNext()) {
/* 192 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 193 */
/* 194 */         smj_numOutputRows.add(1);
/* 195 */
/* 196 */         project_rowWriter.zeroOutNullBytes();
/* 197 */
/* 198 */         if (smj_isNull6) {
/* 199 */           project_rowWriter.setNullAt(0);
/* 200 */         } else {
/* 201 */           project_rowWriter.write(0, smj_value10);
/* 202 */         }
/* 203 */
/* 204 */         if (smj_isNull7) {
/* 205 */           project_rowWriter.setNullAt(1);
/* 206 */         } else {
/* 207 */           project_rowWriter.write(1, smj_value11);
/* 208 */         }
/* 209 */
/* 210 */         if (smj_isNull8) {
/* 211 */           project_rowWriter.setNullAt(2);
/* 212 */         } else {
/* 213 */           project_rowWriter.write(2, smj_value12);
/* 214 */         }
/* 215 */
/* 216 */         if (smj_isNull9) {
/* 217 */           project_rowWriter.setNullAt(3);
/* 218 */         } else {
/* 219 */           project_rowWriter.write(3, smj_value13);
/* 220 */         }
/* 221 */
/* 222 */         if (smj_isNull10) {
/* 223 */           project_rowWriter.setNullAt(4);
/* 224 */         } else {
/* 225 */           project_rowWriter.write(4, smj_value14);
/* 226 */         }
/* 227 */
/* 228 */         if (smj_isNull11) {
/* 229 */           project_rowWriter.setNullAt(5);
/* 230 */         } else {
/* 231 */           project_rowWriter.write(5, smj_value15);
/* 232 */         }
/* 233 */
/* 234 */         if (smj_isNull12) {
/* 235 */           project_rowWriter.setNullAt(6);
/* 236 */         } else {
/* 237 */           project_rowWriter.write(6, smj_value16);
/* 238 */         }
/* 239 */
/* 240 */         if (smj_isNull14) {
/* 241 */           project_rowWriter.setNullAt(7);
/* 242 */         } else {
/* 243 */           project_rowWriter.write(7, smj_value18);
/* 244 */         }
/* 245 */
/* 246 */         if (smj_isNull15) {
/* 247 */           project_rowWriter.setNullAt(8);
/* 248 */         } else {
/* 249 */           project_rowWriter.write(8, smj_value19);
/* 250 */         }
/* 251 */
/* 252 */         if (smj_isNull16) {
/* 253 */           project_rowWriter.setNullAt(9);
/* 254 */         } else {
/* 255 */           project_rowWriter.write(9, smj_value20);
/* 256 */         }
/* 257 */
/* 258 */         if (smj_isNull17) {
/* 259 */           project_rowWriter.setNullAt(10);
/* 260 */         } else {
/* 261 */           project_rowWriter.write(10, smj_value21);
/* 262 */         }
/* 263 */         append(project_result.copy());
/* 264 */
/* 265 */       }
/* 266 */       if (shouldStop()) return;
/* 267 */     }
/* 268 */   }
/* 269 */ }
