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
/* 012 */   private long smj_value9;
/* 013 */   private long smj_value10;
/* 014 */   private long smj_value11;
/* 015 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 016 */   private long smj_value12;
/* 017 */   private long smj_value13;
/* 018 */   private long smj_value14;
/* 019 */   private int smj_value15;
/* 020 */   private boolean smj_isNull9;
/* 021 */   private int smj_value16;
/* 022 */   private boolean smj_isNull10;
/* 023 */   private int smj_value17;
/* 024 */   private boolean smj_isNull11;
/* 025 */   private int smj_value18;
/* 026 */   private boolean smj_isNull12;
/* 027 */   private int smj_value19;
/* 028 */   private boolean smj_isNull13;
/* 029 */   private int smj_value20;
/* 030 */   private boolean smj_isNull14;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 032 */   private UnsafeRow smj_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 035 */   private UnsafeRow project_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 038 */
/* 039 */   public GeneratedIterator(Object[] references) {
/* 040 */     this.references = references;
/* 041 */   }
/* 042 */
/* 043 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 044 */     partitionIndex = index;
/* 045 */     this.inputs = inputs;
/* 046 */     smj_leftInput = inputs[0];
/* 047 */     smj_rightInput = inputs[1];
/* 048 */
/* 049 */     smj_rightRow = null;
/* 050 */
/* 051 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 052 */
/* 053 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 054 */     smj_result = new UnsafeRow(11);
/* 055 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 056 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 11);
/* 057 */     project_result = new UnsafeRow(8);
/* 058 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 059 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
/* 060 */
/* 061 */   }
/* 062 */
/* 063 */   private boolean findNextInnerJoinRows(
/* 064 */     scala.collection.Iterator leftIter,
/* 065 */     scala.collection.Iterator rightIter) {
/* 066 */     smj_leftRow = null;
/* 067 */     int comp = 0;
/* 068 */     while (smj_leftRow == null) {
/* 069 */       if (!leftIter.hasNext()) return false;
/* 070 */       smj_leftRow = (InternalRow) leftIter.next();
/* 071 */
/* 072 */       boolean smj_isNull1 = smj_leftRow.isNullAt(1);
/* 073 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(1));
/* 074 */       boolean smj_isNull = smj_isNull1;
/* 075 */       long smj_value = -1L;
/* 076 */       if (!smj_isNull1) {
/* 077 */         smj_value = (long) smj_value1;
/* 078 */       }
/* 079 */
/* 080 */       boolean smj_isNull3 = smj_leftRow.isNullAt(0);
/* 081 */       int smj_value3 = smj_isNull3 ? -1 : (smj_leftRow.getInt(0));
/* 082 */       boolean smj_isNull2 = smj_isNull3;
/* 083 */       long smj_value2 = -1L;
/* 084 */       if (!smj_isNull3) {
/* 085 */         smj_value2 = (long) smj_value3;
/* 086 */       }
/* 087 */
/* 088 */       boolean smj_isNull5 = smj_leftRow.isNullAt(3);
/* 089 */       int smj_value5 = smj_isNull5 ? -1 : (smj_leftRow.getInt(3));
/* 090 */       boolean smj_isNull4 = smj_isNull5;
/* 091 */       long smj_value4 = -1L;
/* 092 */       if (!smj_isNull5) {
/* 093 */         smj_value4 = (long) smj_value5;
/* 094 */       }
/* 095 */       if (smj_isNull || smj_isNull2 || smj_isNull4) {
/* 096 */         smj_leftRow = null;
/* 097 */         continue;
/* 098 */       }
/* 099 */       if (!smj_matches.isEmpty()) {
/* 100 */         comp = 0;
/* 101 */         if (comp == 0) {
/* 102 */           comp = (smj_value > smj_value12 ? 1 : smj_value < smj_value12 ? -1 : 0);
/* 103 */         }
/* 104 */         if (comp == 0) {
/* 105 */           comp = (smj_value2 > smj_value13 ? 1 : smj_value2 < smj_value13 ? -1 : 0);
/* 106 */         }
/* 107 */         if (comp == 0) {
/* 108 */           comp = (smj_value4 > smj_value14 ? 1 : smj_value4 < smj_value14 ? -1 : 0);
/* 109 */         }
/* 110 */
/* 111 */         if (comp == 0) {
/* 112 */           return true;
/* 113 */         }
/* 114 */         smj_matches.clear();
/* 115 */       }
/* 116 */
/* 117 */       do {
/* 118 */         if (smj_rightRow == null) {
/* 119 */           if (!rightIter.hasNext()) {
/* 120 */             smj_value12 = smj_value;
/* 121 */             smj_value13 = smj_value2;
/* 122 */             smj_value14 = smj_value4;
/* 123 */             return !smj_matches.isEmpty();
/* 124 */           }
/* 125 */           smj_rightRow = (InternalRow) rightIter.next();
/* 126 */
/* 127 */           boolean smj_isNull6 = smj_rightRow.isNullAt(1);
/* 128 */           long smj_value6 = smj_isNull6 ? -1L : (smj_rightRow.getLong(1));
/* 129 */
/* 130 */           boolean smj_isNull7 = smj_rightRow.isNullAt(0);
/* 131 */           long smj_value7 = smj_isNull7 ? -1L : (smj_rightRow.getLong(0));
/* 132 */
/* 133 */           boolean smj_isNull8 = smj_rightRow.isNullAt(2);
/* 134 */           long smj_value8 = smj_isNull8 ? -1L : (smj_rightRow.getLong(2));
/* 135 */           if (smj_isNull6 || smj_isNull7 || smj_isNull8) {
/* 136 */             smj_rightRow = null;
/* 137 */             continue;
/* 138 */           }
/* 139 */           smj_value9 = smj_value6;
/* 140 */           smj_value10 = smj_value7;
/* 141 */           smj_value11 = smj_value8;
/* 142 */         }
/* 143 */
/* 144 */         comp = 0;
/* 145 */         if (comp == 0) {
/* 146 */           comp = (smj_value > smj_value9 ? 1 : smj_value < smj_value9 ? -1 : 0);
/* 147 */         }
/* 148 */         if (comp == 0) {
/* 149 */           comp = (smj_value2 > smj_value10 ? 1 : smj_value2 < smj_value10 ? -1 : 0);
/* 150 */         }
/* 151 */         if (comp == 0) {
/* 152 */           comp = (smj_value4 > smj_value11 ? 1 : smj_value4 < smj_value11 ? -1 : 0);
/* 153 */         }
/* 154 */
/* 155 */         if (comp > 0) {
/* 156 */           smj_rightRow = null;
/* 157 */         } else if (comp < 0) {
/* 158 */           if (!smj_matches.isEmpty()) {
/* 159 */             smj_value12 = smj_value;
/* 160 */             smj_value13 = smj_value2;
/* 161 */             smj_value14 = smj_value4;
/* 162 */             return true;
/* 163 */           }
/* 164 */           smj_leftRow = null;
/* 165 */         } else {
/* 166 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 167 */           smj_rightRow = null;;
/* 168 */         }
/* 169 */       } while (smj_leftRow != null);
/* 170 */     }
/* 171 */     return false; // unreachable
/* 172 */   }
/* 173 */
/* 174 */   protected void processNext() throws java.io.IOException {
/* 175 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 176 */       smj_isNull9 = smj_leftRow.isNullAt(0);
/* 177 */       smj_value15 = smj_isNull9 ? -1 : (smj_leftRow.getInt(0));
/* 178 */       smj_isNull10 = smj_leftRow.isNullAt(1);
/* 179 */       smj_value16 = smj_isNull10 ? -1 : (smj_leftRow.getInt(1));
/* 180 */       smj_isNull11 = smj_leftRow.isNullAt(2);
/* 181 */       smj_value17 = smj_isNull11 ? -1 : (smj_leftRow.getInt(2));
/* 182 */       smj_isNull12 = smj_leftRow.isNullAt(3);
/* 183 */       smj_value18 = smj_isNull12 ? -1 : (smj_leftRow.getInt(3));
/* 184 */       smj_isNull13 = smj_leftRow.isNullAt(4);
/* 185 */       smj_value19 = smj_isNull13 ? -1 : (smj_leftRow.getInt(4));
/* 186 */       smj_isNull14 = smj_leftRow.isNullAt(5);
/* 187 */       smj_value20 = smj_isNull14 ? -1 : (smj_leftRow.getInt(5));
/* 188 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 189 */       while (smj_iterator.hasNext()) {
/* 190 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 191 */
/* 192 */         smj_numOutputRows.add(1);
/* 193 */
/* 194 */         boolean smj_isNull15 = smj_rightRow1.isNullAt(0);
/* 195 */         long smj_value21 = smj_isNull15 ? -1L : (smj_rightRow1.getLong(0));
/* 196 */         boolean smj_isNull16 = smj_rightRow1.isNullAt(1);
/* 197 */         long smj_value22 = smj_isNull16 ? -1L : (smj_rightRow1.getLong(1));
/* 198 */         boolean smj_isNull18 = smj_rightRow1.isNullAt(3);
/* 199 */         long smj_value24 = smj_isNull18 ? -1L : (smj_rightRow1.getLong(3));
/* 200 */         boolean smj_isNull19 = smj_rightRow1.isNullAt(4);
/* 201 */         int smj_value25 = smj_isNull19 ? -1 : (smj_rightRow1.getInt(4));
/* 202 */         project_rowWriter.zeroOutNullBytes();
/* 203 */
/* 204 */         if (smj_isNull9) {
/* 205 */           project_rowWriter.setNullAt(0);
/* 206 */         } else {
/* 207 */           project_rowWriter.write(0, smj_value15);
/* 208 */         }
/* 209 */
/* 210 */         if (smj_isNull11) {
/* 211 */           project_rowWriter.setNullAt(1);
/* 212 */         } else {
/* 213 */           project_rowWriter.write(1, smj_value17);
/* 214 */         }
/* 215 */
/* 216 */         if (smj_isNull13) {
/* 217 */           project_rowWriter.setNullAt(2);
/* 218 */         } else {
/* 219 */           project_rowWriter.write(2, smj_value19);
/* 220 */         }
/* 221 */
/* 222 */         if (smj_isNull14) {
/* 223 */           project_rowWriter.setNullAt(3);
/* 224 */         } else {
/* 225 */           project_rowWriter.write(3, smj_value20);
/* 226 */         }
/* 227 */
/* 228 */         if (smj_isNull15) {
/* 229 */           project_rowWriter.setNullAt(4);
/* 230 */         } else {
/* 231 */           project_rowWriter.write(4, smj_value21);
/* 232 */         }
/* 233 */
/* 234 */         if (smj_isNull16) {
/* 235 */           project_rowWriter.setNullAt(5);
/* 236 */         } else {
/* 237 */           project_rowWriter.write(5, smj_value22);
/* 238 */         }
/* 239 */
/* 240 */         if (smj_isNull18) {
/* 241 */           project_rowWriter.setNullAt(6);
/* 242 */         } else {
/* 243 */           project_rowWriter.write(6, smj_value24);
/* 244 */         }
/* 245 */
/* 246 */         if (smj_isNull19) {
/* 247 */           project_rowWriter.setNullAt(7);
/* 248 */         } else {
/* 249 */           project_rowWriter.write(7, smj_value25);
/* 250 */         }
/* 251 */         append(project_result.copy());
/* 252 */
/* 253 */       }
/* 254 */       if (shouldStop()) return;
/* 255 */     }
/* 256 */   }
/* 257 */ }
