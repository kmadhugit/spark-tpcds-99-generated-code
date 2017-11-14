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
/* 058 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 059 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 060 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 061 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 062 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 063 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 064 */
/* 065 */       // do aggregate
/* 066 */       // common sub-expressions
/* 067 */
/* 068 */       // evaluate aggregate function
/* 069 */       boolean agg_isNull7 = false;
/* 070 */
/* 071 */       boolean agg_isNull8 = agg_bufIsNull;
/* 072 */       long agg_value8 = agg_bufValue;
/* 073 */       if (agg_isNull8) {
/* 074 */         boolean agg_isNull10 = false;
/* 075 */         long agg_value10 = -1L;
/* 076 */         if (!false) {
/* 077 */           agg_value10 = (long) 0;
/* 078 */         }
/* 079 */         if (!agg_isNull10) {
/* 080 */           agg_isNull8 = false;
/* 081 */           agg_value8 = agg_value10;
/* 082 */         }
/* 083 */       }
/* 084 */
/* 085 */       boolean agg_isNull13 = true;
/* 086 */       int agg_value13 = -1;
/* 087 */
/* 088 */       boolean agg_value14 = false;
/* 089 */
/* 090 */       if ((!(inputadapter_isNull))) {
/* 091 */         agg_value14 = inputadapter_isNull2;
/* 092 */       }
/* 093 */       if (!false && agg_value14) {
/* 094 */         agg_isNull13 = false;
/* 095 */         agg_value13 = 1;
/* 096 */       }
/* 097 */
/* 098 */       else {
/* 099 */         agg_isNull13 = false;
/* 100 */         agg_value13 = 0;
/* 101 */       }
/* 102 */       boolean agg_isNull12 = agg_isNull13;
/* 103 */       long agg_value12 = -1L;
/* 104 */       if (!agg_isNull13) {
/* 105 */         agg_value12 = (long) agg_value13;
/* 106 */       }
/* 107 */       long agg_value7 = -1L;
/* 108 */       agg_value7 = agg_value8 + agg_value12;
/* 109 */       boolean agg_isNull19 = false;
/* 110 */
/* 111 */       boolean agg_isNull20 = agg_bufIsNull1;
/* 112 */       long agg_value20 = agg_bufValue1;
/* 113 */       if (agg_isNull20) {
/* 114 */         boolean agg_isNull22 = false;
/* 115 */         long agg_value22 = -1L;
/* 116 */         if (!false) {
/* 117 */           agg_value22 = (long) 0;
/* 118 */         }
/* 119 */         if (!agg_isNull22) {
/* 120 */           agg_isNull20 = false;
/* 121 */           agg_value20 = agg_value22;
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
/* 147 */       long agg_value19 = -1L;
/* 148 */       agg_value19 = agg_value20 + agg_value24;
/* 149 */       boolean agg_isNull31 = false;
/* 150 */
/* 151 */       boolean agg_isNull32 = agg_bufIsNull2;
/* 152 */       long agg_value32 = agg_bufValue2;
/* 153 */       if (agg_isNull32) {
/* 154 */         boolean agg_isNull34 = false;
/* 155 */         long agg_value34 = -1L;
/* 156 */         if (!false) {
/* 157 */           agg_value34 = (long) 0;
/* 158 */         }
/* 159 */         if (!agg_isNull34) {
/* 160 */           agg_isNull32 = false;
/* 161 */           agg_value32 = agg_value34;
/* 162 */         }
/* 163 */       }
/* 164 */
/* 165 */       boolean agg_isNull37 = true;
/* 166 */       int agg_value37 = -1;
/* 167 */
/* 168 */       boolean agg_value38 = false;
/* 169 */
/* 170 */       if ((!(inputadapter_isNull))) {
/* 171 */         agg_value38 = (!(inputadapter_isNull2));
/* 172 */       }
/* 173 */       if (!false && agg_value38) {
/* 174 */         agg_isNull37 = false;
/* 175 */         agg_value37 = 1;
/* 176 */       }
/* 177 */
/* 178 */       else {
/* 179 */         agg_isNull37 = false;
/* 180 */         agg_value37 = 0;
/* 181 */       }
/* 182 */       boolean agg_isNull36 = agg_isNull37;
/* 183 */       long agg_value36 = -1L;
/* 184 */       if (!agg_isNull37) {
/* 185 */         agg_value36 = (long) agg_value37;
/* 186 */       }
/* 187 */       long agg_value31 = -1L;
/* 188 */       agg_value31 = agg_value32 + agg_value36;
/* 189 */       // update aggregation buffer
/* 190 */       agg_bufIsNull = false;
/* 191 */       agg_bufValue = agg_value7;
/* 192 */
/* 193 */       agg_bufIsNull1 = false;
/* 194 */       agg_bufValue1 = agg_value19;
/* 195 */
/* 196 */       agg_bufIsNull2 = false;
/* 197 */       agg_bufValue2 = agg_value31;
/* 198 */       if (shouldStop()) return;
/* 199 */     }
/* 200 */
/* 201 */   }
/* 202 */
/* 203 */   protected void processNext() throws java.io.IOException {
/* 204 */     while (!agg_initAgg) {
/* 205 */       agg_initAgg = true;
/* 206 */       long agg_beforeAgg = System.nanoTime();
/* 207 */       agg_doAggregateWithoutKey();
/* 208 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 209 */
/* 210 */       // output the result
/* 211 */
/* 212 */       agg_numOutputRows.add(1);
/* 213 */       agg_rowWriter.zeroOutNullBytes();
/* 214 */
/* 215 */       if (agg_bufIsNull) {
/* 216 */         agg_rowWriter.setNullAt(0);
/* 217 */       } else {
/* 218 */         agg_rowWriter.write(0, agg_bufValue);
/* 219 */       }
/* 220 */
/* 221 */       if (agg_bufIsNull1) {
/* 222 */         agg_rowWriter.setNullAt(1);
/* 223 */       } else {
/* 224 */         agg_rowWriter.write(1, agg_bufValue1);
/* 225 */       }
/* 226 */
/* 227 */       if (agg_bufIsNull2) {
/* 228 */         agg_rowWriter.setNullAt(2);
/* 229 */       } else {
/* 230 */         agg_rowWriter.write(2, agg_bufValue2);
/* 231 */       }
/* 232 */       append(agg_result);
/* 233 */     }
/* 234 */   }
/* 235 */ }
