/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private long agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private long agg_bufValue2;
/* 015 */   private scala.collection.Iterator inputadapter_input;
/* 016 */   private UnsafeRow project_result;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 021 */   private UnsafeRow agg_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 024 */
/* 025 */   public GeneratedIterator(Object[] references) {
/* 026 */     this.references = references;
/* 027 */   }
/* 028 */
/* 029 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 030 */     partitionIndex = index;
/* 031 */     this.inputs = inputs;
/* 032 */     agg_initAgg = false;
/* 033 */
/* 034 */     inputadapter_input = inputs[0];
/* 035 */     project_result = new UnsafeRow(2);
/* 036 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 037 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 038 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 039 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 040 */     agg_result = new UnsafeRow(3);
/* 041 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 042 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 043 */
/* 044 */   }
/* 045 */
/* 046 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 047 */     // initialize aggregation buffer
/* 048 */     final long agg_value = -1L;
/* 049 */     agg_bufIsNull = true;
/* 050 */     agg_bufValue = agg_value;
/* 051 */     final long agg_value1 = -1L;
/* 052 */     agg_bufIsNull1 = true;
/* 053 */     agg_bufValue1 = agg_value1;
/* 054 */     final long agg_value2 = -1L;
/* 055 */     agg_bufIsNull2 = true;
/* 056 */     agg_bufValue2 = agg_value2;
/* 057 */
/* 058 */     while (inputadapter_input.hasNext()) {
/* 059 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 060 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 061 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 062 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 063 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 064 */
/* 065 */       // do aggregate
/* 066 */       // common sub-expressions
/* 067 */
/* 068 */       boolean agg_isNull7 = false;
/* 069 */       long agg_value7 = -1L;
/* 070 */       if (!false) {
/* 071 */         agg_value7 = (long) 0;
/* 072 */       }
/* 073 */       // evaluate aggregate function
/* 074 */       boolean agg_isNull9 = false;
/* 075 */
/* 076 */       boolean agg_isNull10 = agg_bufIsNull;
/* 077 */       long agg_value10 = agg_bufValue;
/* 078 */       if (agg_isNull10) {
/* 079 */         if (!agg_isNull7) {
/* 080 */           agg_isNull10 = false;
/* 081 */           agg_value10 = agg_value7;
/* 082 */         }
/* 083 */       }
/* 084 */
/* 085 */       boolean agg_isNull14 = true;
/* 086 */       int agg_value14 = -1;
/* 087 */
/* 088 */       boolean agg_value15 = false;
/* 089 */
/* 090 */       if ((!(inputadapter_isNull))) {
/* 091 */         agg_value15 = inputadapter_isNull2;
/* 092 */       }
/* 093 */       if (!false && agg_value15) {
/* 094 */         agg_isNull14 = false;
/* 095 */         agg_value14 = 1;
/* 096 */       }
/* 097 */
/* 098 */       else {
/* 099 */         agg_isNull14 = false;
/* 100 */         agg_value14 = 0;
/* 101 */       }
/* 102 */       boolean agg_isNull13 = agg_isNull14;
/* 103 */       long agg_value13 = -1L;
/* 104 */       if (!agg_isNull14) {
/* 105 */         agg_value13 = (long) agg_value14;
/* 106 */       }
/* 107 */       boolean agg_isNull12 = agg_isNull13;
/* 108 */       long agg_value12 = -1L;
/* 109 */       if (!agg_isNull13) {
/* 110 */         agg_value12 = agg_value13;
/* 111 */       }
/* 112 */       long agg_value9 = -1L;
/* 113 */       agg_value9 = agg_value10 + agg_value12;
/* 114 */       boolean agg_isNull20 = false;
/* 115 */
/* 116 */       boolean agg_isNull21 = agg_bufIsNull1;
/* 117 */       long agg_value21 = agg_bufValue1;
/* 118 */       if (agg_isNull21) {
/* 119 */         if (!agg_isNull7) {
/* 120 */           agg_isNull21 = false;
/* 121 */           agg_value21 = agg_value7;
/* 122 */         }
/* 123 */       }
/* 124 */
/* 125 */       boolean agg_isNull25 = true;
/* 126 */       int agg_value25 = -1;
/* 127 */
/* 128 */       boolean agg_value26 = false;
/* 129 */
/* 130 */       if (inputadapter_isNull) {
/* 131 */         agg_value26 = (!(inputadapter_isNull2));
/* 132 */       }
/* 133 */       if (!false && agg_value26) {
/* 134 */         agg_isNull25 = false;
/* 135 */         agg_value25 = 1;
/* 136 */       }
/* 137 */
/* 138 */       else {
/* 139 */         agg_isNull25 = false;
/* 140 */         agg_value25 = 0;
/* 141 */       }
/* 142 */       boolean agg_isNull24 = agg_isNull25;
/* 143 */       long agg_value24 = -1L;
/* 144 */       if (!agg_isNull25) {
/* 145 */         agg_value24 = (long) agg_value25;
/* 146 */       }
/* 147 */       boolean agg_isNull23 = agg_isNull24;
/* 148 */       long agg_value23 = -1L;
/* 149 */       if (!agg_isNull24) {
/* 150 */         agg_value23 = agg_value24;
/* 151 */       }
/* 152 */       long agg_value20 = -1L;
/* 153 */       agg_value20 = agg_value21 + agg_value23;
/* 154 */       boolean agg_isNull31 = false;
/* 155 */
/* 156 */       boolean agg_isNull32 = agg_bufIsNull2;
/* 157 */       long agg_value32 = agg_bufValue2;
/* 158 */       if (agg_isNull32) {
/* 159 */         if (!agg_isNull7) {
/* 160 */           agg_isNull32 = false;
/* 161 */           agg_value32 = agg_value7;
/* 162 */         }
/* 163 */       }
/* 164 */
/* 165 */       boolean agg_isNull36 = true;
/* 166 */       int agg_value36 = -1;
/* 167 */
/* 168 */       boolean agg_value37 = false;
/* 169 */
/* 170 */       if ((!(inputadapter_isNull))) {
/* 171 */         agg_value37 = (!(inputadapter_isNull2));
/* 172 */       }
/* 173 */       if (!false && agg_value37) {
/* 174 */         agg_isNull36 = false;
/* 175 */         agg_value36 = 1;
/* 176 */       }
/* 177 */
/* 178 */       else {
/* 179 */         agg_isNull36 = false;
/* 180 */         agg_value36 = 0;
/* 181 */       }
/* 182 */       boolean agg_isNull35 = agg_isNull36;
/* 183 */       long agg_value35 = -1L;
/* 184 */       if (!agg_isNull36) {
/* 185 */         agg_value35 = (long) agg_value36;
/* 186 */       }
/* 187 */       boolean agg_isNull34 = agg_isNull35;
/* 188 */       long agg_value34 = -1L;
/* 189 */       if (!agg_isNull35) {
/* 190 */         agg_value34 = agg_value35;
/* 191 */       }
/* 192 */       long agg_value31 = -1L;
/* 193 */       agg_value31 = agg_value32 + agg_value34;
/* 194 */       // update aggregation buffer
/* 195 */       agg_bufIsNull = false;
/* 196 */       agg_bufValue = agg_value9;
/* 197 */
/* 198 */       agg_bufIsNull1 = false;
/* 199 */       agg_bufValue1 = agg_value20;
/* 200 */
/* 201 */       agg_bufIsNull2 = false;
/* 202 */       agg_bufValue2 = agg_value31;
/* 203 */       if (shouldStop()) return;
/* 204 */     }
/* 205 */
/* 206 */   }
/* 207 */
/* 208 */   protected void processNext() throws java.io.IOException {
/* 209 */     while (!agg_initAgg) {
/* 210 */       agg_initAgg = true;
/* 211 */       long agg_beforeAgg = System.nanoTime();
/* 212 */       agg_doAggregateWithoutKey();
/* 213 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 214 */
/* 215 */       // output the result
/* 216 */
/* 217 */       agg_numOutputRows.add(1);
/* 218 */       agg_rowWriter.zeroOutNullBytes();
/* 219 */
/* 220 */       if (agg_bufIsNull) {
/* 221 */         agg_rowWriter.setNullAt(0);
/* 222 */       } else {
/* 223 */         agg_rowWriter.write(0, agg_bufValue);
/* 224 */       }
/* 225 */
/* 226 */       if (agg_bufIsNull1) {
/* 227 */         agg_rowWriter.setNullAt(1);
/* 228 */       } else {
/* 229 */         agg_rowWriter.write(1, agg_bufValue1);
/* 230 */       }
/* 231 */
/* 232 */       if (agg_bufIsNull2) {
/* 233 */         agg_rowWriter.setNullAt(2);
/* 234 */       } else {
/* 235 */         agg_rowWriter.write(2, agg_bufValue2);
/* 236 */       }
/* 237 */       append(agg_result);
/* 238 */     }
/* 239 */   }
/* 240 */ }
